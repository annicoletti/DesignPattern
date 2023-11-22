package br.com.nicoletti.udemy.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author nicoletti
 */
public final class ReflectionUtils {

    public static void printClassInfo(Class<?>... classes) {

        for (Class<?> clazz : classes) {

            System.out.println("clazz: " + clazz);

            System.out.println(String.format("Class name: %s, class package name: %s full-name: %s",
                    clazz.getSimpleName(),
                    clazz.getPackageName(),
                    clazz.getCanonicalName()));

            Class<?>[] implemetedInterfaces = clazz.getInterfaces();
            for (Class<?> implementedInterface : implemetedInterfaces) {
                System.out.println(String.format("Class %s implements : %s",
                        clazz.getSimpleName(),
                        implementedInterface.getSimpleName()));
            }

            System.out.println("Is array : " + clazz.isArray());
            System.out.println("Is primitive : " + clazz.isPrimitive());
            System.out.println("Is enum : " + clazz.isEnum());
            System.out.println("Is interface : " + clazz.isInterface());
            System.out.println("Is anonymus : " + clazz.isAnonymousClass());
            System.out.println("Type : " + clazz.getComponentType().getTypeName());

            System.out.println("");

        }
    }

    public static void printConstructorData(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        System.out.println(String.format("class %s has %d declared constructors",
                clazz.getSimpleName(),
                constructors.length));

        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            List<String> parameterTypeNames = Arrays.stream(parameterTypes)
                    .map(type -> type.getSimpleName())
                    .collect(Collectors.toList());
            System.out.println(parameterTypeNames);
        }

    }

    public static <T> T createInstanceWithArguments(Class<T> clazz, Object... args) {

        printConstructorData(clazz);

        try {

            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                if (constructor.getParameterTypes().length == args.length) {
                    return (T) constructor.newInstance(args);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("An appropriate constuctor was not found");
        return null;
    }

    public static void printDeclaredFieldsInfo(Class<?> clazz) {

        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(String.format("Field name: %s type: %s generic: %s",
                    field.getName(),
                    field.getType().getName(),
                    field.getGenericType().getTypeName()));

            System.out.println();
        }

    }

    public static Object parseArray(Class<?> arrayElementType, String value) {

        String[] elements = value.split(",");

        Object arrayObject = Array.newInstance(arrayElementType, elements.length);

        for (int i = 0; i < elements.length; i++) {
            Array.set(arrayObject, i, parseValue(arrayElementType, elements[i]));
        }

        return arrayObject;
    }

    public static Object parseValue(Class<?> type, String value) {
        if (type.equals(int.class)) {
            return Integer.valueOf(value);
        } else if (type.equals(short.class)) {
            return Short.valueOf(value);
        } else if (type.equals(long.class)) {
            return Long.valueOf(value);
        } else if (type.equals(double.class)) {
            return Double.valueOf(value);
        } else if (type.equals(float.class)) {
            return Float.valueOf(value);
        } else if (type.equals(String.class)) {
            return value;
        }

        throw new RuntimeException(String.format("Type : %s unsupported",
                type.getTypeName()));
    }

    public static <T> Object createInstanceWithArgumentsV2(Class<T> clazz, Object... args) {

        Object object = null;
//        printConstructorData(clazz);

        try {

            Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
            if (declaredConstructors.length > 0) {
                // Se houver construtor executa
                System.out.println("more than 0 constructors");
                Constructor<?> constructor = findConstructor(declaredConstructors, args);
                constructor.setAccessible(true);

                object = constructor.newInstance(args);

            } else if (clazz.isArray()) {
                // Se não existir construtor, verifica se é um array
                System.out.println("this class is an Array[] = " + clazz.getComponentType().getName() + " - " + args.length);

                Class<?> clazzCast = Class.forName(clazz.getComponentType().getName());
                object = Array.newInstance(clazzCast, args.length);

                // Preenche o array com os dados enviado pelo argumento 
                for (int i = 0; i < args.length; i++) {
                    Object arg = args[i];
                    Object obj = createInstanceWithArgumentsV2(arg.getClass(), arg);
                    Array.set(object, i, obj);
                }

            } else {
                // Se for do tipo primário
                throw new RuntimeException("Não é possivel instanciar objeto");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;

    }

    private static Constructor<?> findConstructor(Constructor<?>[] constructors, Object[] args) {

        for (Constructor<?> constructor : constructors) {

            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == args.length) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    String paramType = parameterTypes[i].getName();
                    String argsType = args[i].getClass().getName();
                    if (!paramType.equals(argsType)) {
                        continue;
                    }
                    return constructor;
                }
            }
        }

        throw new RuntimeException("An appropriate constuctor was not found");
    }

}

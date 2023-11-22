package br.com.nicoletti.udemy.reflection.class1;

import br.com.nicoletti.udemy.reflection.ReflectionUtils;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nicoletti
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<String> stringClass = String.class;

        Map<String, Integer> mapObject = new HashMap<>();
        Class<?> mapClass = mapObject.getClass();

        Class<Integer> integerClass = Integer.class;

        Class<?> squareClass = Class.forName("br.com.nicoletti.udemy.reflection.class1.Main$Square");

        ReflectionUtils.printClassInfo(stringClass, mapClass, integerClass, squareClass, String[].class);
        
        ReflectionUtils.printClassInfo(Collection.class, boolean.class, int[][].class, int.class);

        try {
            Class<?> stringClazz = Class.forName("java.lang.String");
            Object arrayObj = Array.newInstance(stringClazz, 0);
            
            Object createArray = createArray(stringClazz);
            String[] createArray1 = createArray(String[].class);

            String[] array = (String[]) arrayObj;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static <T> T createArray(Class<T> clazz) {
        T obj = (T) Array.newInstance(clazz, 0);
        return obj;
    }

    private class Square implements Drawable {

        @Override
        public int getNumberOfCorners() {
            return 4;
        }

    }

    private interface Drawable {

        int getNumberOfCorners();

    }

    private enum Color {
        BLUE, RED, GREEN
    }
}

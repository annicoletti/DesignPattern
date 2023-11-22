package br.com.nicoletti.udemy.reflection;

import org.json.JSONObject;

/**
 *
 * @author nicoletti
 */
public class Main {

    private static final String CLASS_LONG = "java.lang.Long";
    private static final String CLASS_STRING = "java.lang.String";
    private static final String CLASS_INTEGER = "java.lang.Integer";
    private static final String CLASS_LIST = "java.util.ArrayList";
    private static final String CLASS_ARRAY_STRING = "[Ljava.lang.String;";
    private static final String CLASS_ARRAY_INTEGER = "[Ljava.lang.Integer;";
    private static final String CLASS_ARRAY_FLOAT = "[Ljava.lang.Float;";

    private static final ReflectionService service = new ReflectionService();

    public static void main(String[] args) {

//        initArrayList();
        initArray();

    }

    private static void initArrayList() {
        try {

            Class<?> clazz = Class.forName(CLASS_LIST);

            ReflectionUtils.printClassInfo(clazz);
            ReflectionUtils.printConstructorData(clazz);

            Object obj = ReflectionUtils.createInstanceWithArguments(clazz);

            System.out.println("obj: " + obj.getClass());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initArray() {
        try {

            Class<?> clazzArrayString = Class.forName(CLASS_ARRAY_STRING);
            Class<?> clazzArrayInteger = Class.forName(CLASS_ARRAY_INTEGER);
            Class<?> clazzArrayFloat = Class.forName(CLASS_ARRAY_FLOAT);
            Class<?> clazzString = Class.forName(CLASS_STRING);
            Class<?> clazzInteger = Class.forName(CLASS_INTEGER);
            Class<?> clazzLong = Class.forName(CLASS_LONG);

            Object stringArray = service.createInstanceWithArgumentsV2(clazzArrayString, "a", "b", "c");
            Object integerArray = service.createInstanceWithArgumentsV2(clazzArrayInteger, "3", "2", "1");
            Object floatArray = service.createInstanceWithArgumentsV2(clazzArrayFloat, "3.1", "2.2", "1.3");
            Object string = service.createInstanceWithArgumentsV2(clazzString, "uma mensagem de teste");
            Object integer = service.createInstanceWithArgumentsV2(clazzInteger, "101");
            Object longer = service.createInstanceWithArgumentsV2(clazzLong, "999000111222333");

            Teste teste = new Teste(stringArray, integerArray, floatArray, string, integer, longer);
            System.out.println("[JSON OBJECT] - " + new JSONObject(teste).toString(4));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Teste {

        public Object stringArray;
        public Object integerArray;
        public Object floatArray;
        public Object string;
        public Object integer;
        public Object longer;

        public Teste(Object stringArray, Object integerArray, Object floatArray, Object string, Object integer, Object longer) {
            this.stringArray = stringArray;
            this.integerArray = integerArray;
            this.floatArray = floatArray;
            this.string = string;
            this.integer = integer;
            this.longer = longer;
        }

        public Object getLonger() {
            return longer;
        }

        public void setLonger(Object longer) {
            this.longer = longer;
        }

        public Object getString() {
            return string;
        }

        public void setString(Object string) {
            this.string = string;
        }

        public Object getInteger() {
            return integer;
        }

        public void setInteger(Object integer) {
            this.integer = integer;
        }

        public Object getStringArray() {
            return stringArray;
        }

        public void setStringArray(Object stringArray) {
            this.stringArray = stringArray;
        }

        public Object getIntegerArray() {
            return integerArray;
        }

        public void setIntegerArray(Object integerArray) {
            this.integerArray = integerArray;
        }

        public Object getFloatArray() {
            return floatArray;
        }

        public void setFloatArray(Object floatArray) {
            this.floatArray = floatArray;
        }

    }

}

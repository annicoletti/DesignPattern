package br.com.nicoletti.udemy.reflection.class5;

import br.com.nicoletti.udemy.reflection.ReflectionUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

/**
 *
 * @author nicoletti
 */
public class Main {

    public static void main(String[] args) {

        Map<String, String> config = new HashMap<>();
        config.put("numeric", "101");
        config.put("decimal", "99.01");
        config.put("text", "Loren");
        config.put("textArrays", "a,b,c,d,e,f,g");

        ReflectionUtils.printDeclaredFieldsInfo(Demonstration.class);

        try {
            Demonstration demo = createDemonstrationObject(Demonstration.class, config);
            System.out.println(demo);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static <T> T createDemonstrationObject(Class<T> clazz, Map<String, String> config) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        T demoObject = (T) constructor.newInstance();

        for (Map.Entry<String, String> entry : config.entrySet()) {

            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);

            System.out.println("field.getType(): " + field.getType());
            System.out.println("field.getType().getComponentType(): " + field.getType().getComponentType());
            
            Object parsedValue;
            if (field.getType().isArray()) {
                parsedValue = ReflectionUtils.parseArray(field.getType().getComponentType(), entry.getValue());
            } else {
                parsedValue = ReflectionUtils.parseValue(field.getType(), entry.getValue());
            }

            field.set(demoObject, parsedValue);

        }

        return demoObject;
    }

    public static class Demonstration {

        private int numeric;
        private double decimal;
        private String text;
        private String[] textArrays;

        public int getNumeric() {
            return numeric;
        }

        public void setNumeric(int numeric) {
            this.numeric = numeric;
        }

        public double getDecimal() {
            return decimal;
        }

        public void setDecimal(double decimal) {
            this.decimal = decimal;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String[] getTextArrays() {
            return textArrays;
        }

        public void setTextArrays(String[] textArrays) {
            this.textArrays = textArrays;
        }

        @Override
        public String toString() {
            return "Demonstration{" + "numeric=" + numeric + ", decimal=" + decimal + ", text=" + text + ", textArrays=" + Arrays.asList(textArrays) + '}';
        }

    }

}

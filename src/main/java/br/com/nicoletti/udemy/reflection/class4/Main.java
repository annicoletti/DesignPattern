package br.com.nicoletti.udemy.reflection.class4;

import br.com.nicoletti.udemy.reflection.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author nicoletti
 */
public class Main {
    
    public static void main(String[] args) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        
        ReflectionUtils.printDeclaredFieldsInfo(ArrayList.class);
        
        Field serialVersionField = ArrayList.class.getDeclaredField("serialVersionUID");
        serialVersionField.setAccessible(true);
        
        System.out.println("field serialVersionField value: " + serialVersionField.get(null));
        
    }
    
}

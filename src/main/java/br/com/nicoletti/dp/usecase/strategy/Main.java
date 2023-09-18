package br.com.nicoletti.dp.usecase.strategy;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicoletti
 */
public class Main {

    public static void main(String[] args) {

        Integer n1 = 1;
        Integer n2 = 10;

        String t1 = "xpto";
        String t2 = "abc";

        CheckCriteria checkCriteria = new CheckCriteria();

        checkCriteria.setValues(n1, n2);
        checkCriteria.setStrategy(new CriteriaInteger());
        checkCriteria.check(OperandType.EQUALS_TO);
        checkCriteria.check(OperandType.GREATER_THAN);
        checkCriteria.check(OperandType.GREATER_THAN_OR_EQUALS_TO);
        checkCriteria.check(OperandType.LOWER_THAN);
        checkCriteria.check(OperandType.LOWER_THAN_OR_EQUALS_TO);
        checkCriteria.check(OperandType.NOT_EQUALS_TO);

        checkCriteria.setValues(t1, t2);
        checkCriteria.setStrategy(new CriteriaText());
        checkCriteria.check(OperandType.EQUALS_TO);
        checkCriteria.check(OperandType.GREATER_THAN);
        checkCriteria.check(OperandType.GREATER_THAN_OR_EQUALS_TO);
        checkCriteria.check(OperandType.LOWER_THAN);
        checkCriteria.check(OperandType.LOWER_THAN_OR_EQUALS_TO);
        checkCriteria.check(OperandType.NOT_EQUALS_TO);

    }

    private static void testClass() {
        try {

            Long longo = 1234567890123456789L;
            System.out.println("long class: " + longo.getClass().getName());
            String valLong = "1234567890123456789";

            Object newInstance1 = Class.forName("java.lang.Long").getConstructor(String.class).newInstance(valLong);

            System.out.println("VALOR: newInstance1");
            System.out.println(newInstance1);
            System.out.println(newInstance1.getClass());

        } catch (InvocationTargetException | ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

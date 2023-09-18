package br.com.nicoletti.dp.usecase.strategy;

/**
 *
 * @author nicoletti
 */
public class CriteriaText implements CriteriaStrategy<String> {

    @Override
    public boolean match(OperandType operandType, String obj1, String obj2) {

        switch (operandType) {
            case EQUALS_TO:
                return obj1.equals(obj2);
            case NOT_EQUALS_TO:
                return !obj1.equals(obj2);
            case GREATER_THAN:
                return obj1.length() > obj2.length();
            case GREATER_THAN_OR_EQUALS_TO:
                return obj1.length() >= obj2.length();
            default:
                System.out.println("Nenhum Operador conhecido");
                return false;
        }

    }

}

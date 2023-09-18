package br.com.nicoletti.dp.usecase.strategy;

/**
 *
 * @author nicoletti
 */
public class CriteriaInteger implements CriteriaStrategy<Integer> {

    @Override
    public boolean match(OperandType operandType, Integer obj1, Integer obj2) {

        switch (operandType) {
            case EQUALS_TO:
                return obj1.equals(obj2);
            case NOT_EQUALS_TO:
                return !obj1.equals(obj2);
            case GREATER_THAN:
                return obj1 > obj2;
            case LOWER_THAN_OR_EQUALS_TO:
                return obj1 <= obj2;
            case GREATER_THAN_OR_EQUALS_TO:
                return obj1 >= obj2;
            case LOWER_THAN:
                return obj1 < obj2;
            default:
                System.out.println("Nenhum Operador conhecido");
                return false;
        }

    }

}

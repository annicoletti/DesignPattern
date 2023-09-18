package br.com.nicoletti.dp.usecase.chain;

import static br.com.nicoletti.dp.usecase.chain.CriteriaType.EQUALS_TO;
import static br.com.nicoletti.dp.usecase.chain.CriteriaType.GREATER_THAN;
import static br.com.nicoletti.dp.usecase.chain.CriteriaType.GREATER_THAN_OR_EQUALS_TO;
import static br.com.nicoletti.dp.usecase.chain.CriteriaType.LOWER_THAN;
import static br.com.nicoletti.dp.usecase.chain.CriteriaType.LOWER_THAN_OR_EQUALS_TO;
import static br.com.nicoletti.dp.usecase.chain.CriteriaType.NOT_EQUALS_TO;

/**
 *
 * @author nicoletti
 */
public class OperationCheckerFloat implements OperationChecker<Float> {

    @Override
    public boolean match(CriteriaType operandType, Float obj1, Float obj2) {

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

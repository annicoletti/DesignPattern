package br.com.nicoletti.dp.usecase.chain.v2;

import java.util.Objects;

/**
 *
 * @author nicoletti
 */
public class OperationCheckerBoolean implements OperationChecker<Boolean> {

    @Override
    public boolean match(CriteriaType operandType, Boolean obj1, Boolean obj2) {

        switch (operandType) {
            case EQUALS_TO:
                return Objects.equals(obj1, obj2);
            case NOT_EQUALS_TO:
                return !Objects.equals(obj1, obj2);
            default:
                System.out.println("Nenhum Operador conhecido");
                return false;

        }

    }

}

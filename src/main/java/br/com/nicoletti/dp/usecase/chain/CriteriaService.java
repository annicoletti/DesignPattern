package br.com.nicoletti.dp.usecase.chain;

/**
 *
 * @author nicoletti
 */
public class CriteriaService {

    private OperationChecker operation;

    public boolean check(CriteriaType operandType, Object obj1, Object obj2) {
        boolean match = operation.match(operandType, obj1, obj2);
        System.out.println(obj1 + " " + operandType.name() + " " + obj2 + " = " + match);
        return match;
    }

}

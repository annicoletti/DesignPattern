package br.com.nicoletti.dp.usecase.chain.v2;

/**
 *
 * @author nicoletti
 */
public class ProcessStepInteger extends ProcessStep {

    @Override
    OperationChecker execute(Object obj1, Object obj2, CriteriaType type) {
        if (obj1 instanceof Integer && obj2 instanceof Integer) {
            return new OperationCheckerInteger();
        }
        return next(obj1, obj2, type);
    }

}

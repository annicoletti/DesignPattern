package br.com.nicoletti.dp.usecase.chain.v2;

/**
 *
 * @author nicoletti
 */
public class ProcessStepLong extends ProcessStep {

    @Override
    OperationChecker execute(Object obj1, Object obj2, CriteriaType type) {
        if (obj1 instanceof Long && obj2 instanceof Long) {
            return new OperationCheckerInteger();
        }
        return next(obj1, obj2, type);
    }

}

package br.com.nicoletti.dp.usecase.chain.v2;

/**
 *
 * @author nicoletti
 */
public class ProcessStepBoolean extends ProcessStep {

    @Override
    OperationChecker execute(Object obj1, Object obj2, CriteriaType type) {
        if (obj1 instanceof Boolean && obj2 instanceof Boolean) {
            return new OperationCheckerBoolean();
        }
        return next(obj1, obj2, type);
    }

}

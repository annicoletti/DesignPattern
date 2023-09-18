package br.com.nicoletti.dp.usecase.chain.v2;

/**
 *
 * @author nicoletti
 */
public class ProcessStepString extends ProcessStep {

    @Override
    OperationChecker execute(Object obj1, Object obj2, CriteriaType type) {
        if (obj1 instanceof String && obj2 instanceof String) {
            return new OperationCheckerString();
        }
        return next(obj1, obj2, type);
    }

}

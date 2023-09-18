package br.com.nicoletti.dp.usecase.chain.v2;

/**
 *
 * @author nicoletti
 */
public class ProcessStepDouble extends ProcessStep {

    @Override
    OperationChecker execute(Object obj1, Object obj2, CriteriaType type) {
        if (obj1 instanceof Double && obj2 instanceof Double) {
            return new OperationCheckerDouble();
        }
        return next(obj1, obj2, type);
    }

}

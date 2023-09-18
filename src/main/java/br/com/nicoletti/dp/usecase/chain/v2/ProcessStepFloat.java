package br.com.nicoletti.dp.usecase.chain.v2;

/**
 *
 * @author nicoletti
 */
public class ProcessStepFloat extends ProcessStep {
    
    @Override
    OperationChecker execute(Object obj1, Object obj2, CriteriaType type) {
        if (obj1 instanceof Float && obj2 instanceof Float) {
            return new OperationCheckerFloat();
        }
        return next(obj1, obj2, type);
    }
    
}

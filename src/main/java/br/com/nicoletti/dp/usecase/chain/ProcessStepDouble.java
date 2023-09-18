package br.com.nicoletti.dp.usecase.chain;

/**
 *
 * @author nicoletti
 */
public class ProcessStepDouble extends ProcessStep {

    @Override
    OperationChecker execute(Context context) {
        if (context.getObj1() instanceof Double && context.getObj2() instanceof Double) {
            return new OperationCheckerDouble();
        }
        return next(context);
    }

}

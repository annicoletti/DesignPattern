package br.com.nicoletti.dp.usecase.chain;

/**
 *
 * @author nicoletti
 */
public class ProcessStepString extends ProcessStep {

    @Override
    OperationChecker execute(Context context) {
        if (context.getObj1() instanceof String && context.getObj2() instanceof String) {
            return new OperationCheckerString();
        }
        return next(context);
    }

}

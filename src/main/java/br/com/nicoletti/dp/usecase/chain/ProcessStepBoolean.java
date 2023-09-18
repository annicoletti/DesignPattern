package br.com.nicoletti.dp.usecase.chain;

/**
 *
 * @author nicoletti
 */
public class ProcessStepBoolean extends ProcessStep {

    @Override
    OperationChecker execute(Context context) {
        if (context.getObj1() instanceof Boolean && context.getObj2() instanceof Boolean) {
            return new OperationCheckerBoolean();
        }
        return next(context);
    }

}

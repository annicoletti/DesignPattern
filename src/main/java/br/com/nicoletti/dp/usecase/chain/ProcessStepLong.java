package br.com.nicoletti.dp.usecase.chain;

/**
 *
 * @author nicoletti
 */
public class ProcessStepLong extends ProcessStep {

    @Override
    OperationChecker execute(Context context) {
        if (context.getObj1() instanceof Long && context.getObj2() instanceof Long) {
            return new OperationCheckerInteger();
        }
        return next(context);
    }

}

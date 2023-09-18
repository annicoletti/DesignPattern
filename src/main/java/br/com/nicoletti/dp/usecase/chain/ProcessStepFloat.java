package br.com.nicoletti.dp.usecase.chain;

/**
 *
 * @author nicoletti
 */
public class ProcessStepFloat extends ProcessStep {

    @Override
    OperationChecker execute(Context context) {
        if (context.getObj1() instanceof Float && context.getObj2() instanceof Float) {
            return new OperationCheckerFloat();
        }
        return next(context);
    }

}

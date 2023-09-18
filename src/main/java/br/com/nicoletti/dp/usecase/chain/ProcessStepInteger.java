package br.com.nicoletti.dp.usecase.chain;

/**
 *
 * @author nicoletti
 */
public class ProcessStepInteger extends ProcessStep {

    @Override
    OperationChecker execute(Context context) {
        if (context.getObj1() instanceof Integer && context.getObj2() instanceof Integer) {
            return new OperationCheckerInteger();
        }
        return next(context);
    }

}

package br.com.nicoletti.dp.usecase.chain;

/**
 *
 * @author nicoletti
 */
public abstract class ProcessStep {

    private ProcessStep next;

    public void setNextStep(ProcessStep next) {
        this.next = next;
    }

    public OperationChecker next(Context context) {
        if (next == null) {
            throw new RuntimeException("Não foi possível verificar");
        }
        return next.execute(context);
    }

    abstract OperationChecker execute(Context context);

}

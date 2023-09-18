package br.com.nicoletti.dp.usecase.chain.v2;

/**
 *
 * @author nicoletti
 */
public abstract class ProcessStep {

    private ProcessStep next;

    public void setNextStep(ProcessStep next) {
        this.next = next;
    }

    public OperationChecker next(Object obj1, Object obj2, CriteriaType type) {
        if (next == null) {
            throw new RuntimeException("Não foi possível verificar");
        }
        return next.execute(obj1, obj2, type);
    }

    abstract OperationChecker execute(Object obj1, Object obj2, CriteriaType type);

}

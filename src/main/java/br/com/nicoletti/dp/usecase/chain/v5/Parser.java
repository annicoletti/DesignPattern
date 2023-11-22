package br.com.nicoletti.dp.usecase.chain.v5;

/**
 *
 * @author nicoletti
 */
public abstract class Parser {

    private Parser next;

    public void setNextStep(Parser next) {
        this.next = next;
    }

    public Object next(String value, InputType type) throws Exception {
        if (next == null) {
            throw new RuntimeException("Não foi possível verificar");
        }
        return next.execute(value, type);
    }

    abstract Object execute(String value, InputType type) throws Exception;

}

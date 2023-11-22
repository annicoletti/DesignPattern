package br.com.nicoletti.dp.usecase.chain.v4;

/**
 *
 * @author nicoletti
 */
public abstract class Handler {

    protected Handler next;

    public boolean handler(String request) {
        if (next == null) {
            throw new RuntimeException("não é possivel verificar");
        }
        return next.execute(request);
    }

    abstract boolean execute(String request);
}

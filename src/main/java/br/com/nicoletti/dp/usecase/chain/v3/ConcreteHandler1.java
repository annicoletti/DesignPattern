package br.com.nicoletti.dp.usecase.chain.v3;

/**
 *
 * @author nicoletti
 */
public class ConcreteHandler1 extends Handler {

    public ConcreteHandler1(Handler next) {
        super(next);
    }

    @Override
    boolean execute(String request) {
        System.out.println("executing handler 1");
        if (request != null && request.length() < 10) {
            System.out.println("Handle 1 ok");
            return true;
        }
        return handler(request);

    }

}

package br.com.nicoletti.dp.usecase.chain.v3;

/**
 *
 * @author nicoletti
 */
public class ConcreteHandler3 extends Handler {

    public ConcreteHandler3(Handler next) {
        super(next);
    }

    @Override
    boolean execute(String request) {
        System.out.println("executing handler 3");
        if (request != null && request.length() < 20) {
            System.out.println("Handle 3 ok");
            return true;
        }
        return handler(request);
    }

}

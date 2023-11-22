package br.com.nicoletti.dp.usecase.chain.v4;

/**
 *
 * @author nicoletti
 */
public class ConcreteHandler2 extends Handler {

    @Override
    boolean execute(String request) {
        System.out.println("executing handler 2");
        if (request != null && request.length() < 15) {
            System.out.println("Handle 2 ok");
            return true;
        }
        
        return new ConcreteHandler3().execute(request);
    }

}

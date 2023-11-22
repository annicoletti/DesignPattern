package br.com.nicoletti.dp.usecase.chain.v5;

/**
 *
 * @author nicoletti
 */
public class Service {

    Object execute(String value, InputType type) throws Exception {
        Parser verifier = ParserBuilder.verifyAll;
        return verifier.execute(value, type);
    }

}

package br.com.nicoletti.dp.usecase.chain.v5;

/**
 *
 * @author nicoletti
 */
public class ParserString extends Parser {

    @Override
    Object execute(String value, InputType type) throws Exception {
        if (type.equals(InputType.STRING)) {
            return String.valueOf(value);
        }
        return next(value, type);
    }

}

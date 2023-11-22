package br.com.nicoletti.dp.usecase.chain.v5;

/**
 *
 * @author nicoletti
 */
public class ParserInteger extends Parser {

    @Override
    Object execute(String value, InputType type) throws Exception {
        if (type.equals(InputType.INTEGER)) {
            return Integer.valueOf(value);
        }
        return next(value, type);
    }

}

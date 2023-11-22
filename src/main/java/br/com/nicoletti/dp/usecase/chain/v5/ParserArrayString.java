package br.com.nicoletti.dp.usecase.chain.v5;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 *
 * @author nicoletti
 */
public class ParserArrayString extends Parser {

    @Override
    Object execute(String value, InputType type) throws Exception {
        if (type.equals(InputType.ARRAY_STRING)) {

            ObjectMapper mapper = new ObjectMapper();
            List<String> stringList = mapper.readValue(value, new TypeReference<List<String>>() {
            });

            return stringList;
        }
        return next(value, type);
    }

}

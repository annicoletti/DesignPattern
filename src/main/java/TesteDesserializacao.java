
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicoletti
 */
public class TesteDesserializacao {

    public static void main(String[] args) throws JsonProcessingException {

        String string = "None";
        String integer = "-1";
        String array_string = "[\"oi\",\"como tu tá\"]";

        ObjectMapper mapper = new ObjectMapper();

        ArrayList readValue = mapper.readValue(array_string, ArrayList.class);

        List<String> readValue1 = mapper.readValue(array_string, new TypeReference<List<String>>() {
        });

        String[] readValue2 = mapper.readValue(array_string, new TypeReference<String[]>() {
        });

        System.out.println("readValue: " + readValue + " - " + mapper.writeValueAsString(readValue));
        System.out.println("readValue1: " + readValue1 + " - " + mapper.writeValueAsString(readValue1));
        System.out.println("readValue2: " + readValue2 + " - " + mapper.writeValueAsString(readValue2));
    }

}

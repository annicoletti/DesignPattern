package br.com.nicoletti.dp.usecase.chain.v5;

/**
 *
 * @author nicoletti
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Service service = new Service();

        InputType type = InputType.ARRAY_STRING;

        String value = "[\"a\",\"b\",\"c\"]";

        Object result = service.execute(value, type);

        System.out.println("result: " + result + " class: " + result.getClass());

    }

}

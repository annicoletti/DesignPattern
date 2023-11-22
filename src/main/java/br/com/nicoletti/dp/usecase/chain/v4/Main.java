package br.com.nicoletti.dp.usecase.chain.v4;

/**
 *
 * @author nicoletti
 */
public class Main {

    public static void main(String[] args) {

        ConcreteHandler1 ch1 = new ConcreteHandler1();

        boolean result = ch1.execute("123456789");

        System.out.println("result: " + result);

    }

}

package br.com.nicoletti.dp.usecase.chain.v3;

/**
 *
 * @author nicoletti
 */
public class Main {

    public static void main(String[] args) {

        ConcreteHandler3 ch3 = new ConcreteHandler3(null);
        ConcreteHandler2 ch2 = new ConcreteHandler2(ch3);
        ConcreteHandler1 ch1 = new ConcreteHandler1(ch2);

        ch1.execute("12345678901234567890");

    }

}

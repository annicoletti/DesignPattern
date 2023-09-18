package br.com.nicoletti.dp.headfirst.strategy;

/**
 *
 * @author nicoletti
 */
public class FlyNoWay implements FlyBehavior {

    public void fly() {
        System.out.println("Não posso voar!");
    }

}

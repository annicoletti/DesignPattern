package br.com.nicoletti.dp.headfirst.strategy;

/**
 *
 * @author nicoletti
 */
public class MuteQuack implements QuackBehavior {

    public void quack() {
        System.out.println("Não faço som.");
    }

}

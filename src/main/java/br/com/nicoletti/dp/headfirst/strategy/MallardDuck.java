package br.com.nicoletti.dp.headfirst.strategy;

/**
 *
 * @author nicoletti
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("Sou um modelo de pato.");
    }

}

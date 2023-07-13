package br.com.nicoletti.dp.strategy;

/**
 *
 * @author nicoletti
 */
public class Main {

    public static void main(String[] args) {

        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();

        Duck model = new MallardDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPower());
        model.performFly();

    }

}

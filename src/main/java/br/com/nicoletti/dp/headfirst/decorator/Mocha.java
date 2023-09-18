package br.com.nicoletti.dp.headfirst.decorator;

/**
 *
 * @author nicoletti
 */
public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription().concat(", Mocha");
    }

    @Override
    public double coast() {
        return .20 + beverage.coast();
    }

}

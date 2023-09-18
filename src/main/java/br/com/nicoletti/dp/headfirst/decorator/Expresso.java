package br.com.nicoletti.dp.headfirst.decorator;

/**
 *
 * @author nicoletti
 */
public class Expresso extends Beverage {

    public Expresso() {
        description = "Expresso";
    }

    @Override
    public double coast() {
        return 1.99;
    }

}

package br.com.nicoletti.dp.headfirst.decorator;

/**
 *
 * @author nicoletti
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double coast() {
        return .89;
    }

}

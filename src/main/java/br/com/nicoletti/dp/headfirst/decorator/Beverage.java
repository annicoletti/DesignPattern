package br.com.nicoletti.dp.headfirst.decorator;

/**
 *
 * @author nicoletti
 */
public abstract class Beverage {

    String description = "unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double coast();
}

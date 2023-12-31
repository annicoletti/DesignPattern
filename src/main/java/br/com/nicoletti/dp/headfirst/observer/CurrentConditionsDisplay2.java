package br.com.nicoletti.dp.headfirst.observer;

/**
 *
 * @author nicoletti
 */
public class CurrentConditionsDisplay2 implements Observer, DisplayElement {

    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay2(Subject... observables) {
        registy(observables);
    }

    @Override
    public void update(Subject subject) {
        if (subject instanceof WeatherData2) {
            WeatherData2 sub = (WeatherData2) subject;
            this.temperature = sub.getTemperature();
            this.humidity = sub.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Condições atuais: " + temperature + "°C e " + humidity + "% humidade.");
        System.out.println("Heat index is " + computeHeatIndex(temperature, humidity));

    }

    private float computeHeatIndex(float t, float rh) {
        float index = (float) ((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh)
                + (0.00941695 * (t * t)) + (0.00728898 * (rh * rh))
                + (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh))
                + (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583
                * (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh))
                + (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh))
                + 0.000000000843296 * (t * t * rh * rh * rh))
                - (0.0000000000481975 * (t * t * t * rh * rh * rh)));
        return index;
    }

}

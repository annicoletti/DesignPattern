package br.com.nicoletti.dp.headfirst.observer;

/**
 *
 * @author nicoletti
 */
public class Main {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        WeatherData2 weatherData2 = new WeatherData2();
        CurrentConditionsDisplay2 currentConditionsDisplay2 = new CurrentConditionsDisplay2(weatherData2);

        //mock
        System.out.println("WeatherData2");
        weatherData2.setMeasurements(20, 65, 30.4f);
        weatherData2.setMeasurements(25, 70, 29.2f);
        weatherData2.setMeasurements(23, 90, 29.2f);

        System.out.println("WeatherData");
        weatherData.setMeasurements(20, 65, 30.4f);
        weatherData.setMeasurements(25, 70, 29.2f);
        weatherData.setMeasurements(23, 90, 29.2f);

    }

}

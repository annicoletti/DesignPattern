package br.com.nicoletti.dp.headfirst.observer;

/**
 *
 * @author nicoletti
 */
public class WeatherData2 implements Subject {

    private float temperature;
    private float humidity;
    private float pressure;

    public void measurementsChanged() {
        notifyObservers();
    }

    /**
     * Mock de dados da estação meteorologica
     *
     * @param temperature
     * @param humidity
     * @param pressure
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

}

package com.example.model;

public class WeatherResponse {

    private double temperature;
    private int humidity;

    @Override
	public String toString() {
		return "WeatherResponse [temperature=" + temperature + ", humidity=" + humidity + "]";
	}

	public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}

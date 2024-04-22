package com.example.weatherapp.model;

import java.util.List;

public class ForecastData {

    private List<WeatherEntry> list;

    public List<WeatherEntry> getList() {
        return list;
    }

    public void setList(List<WeatherEntry> list) {
        this.list = list;
    }

    public static class WeatherEntry {
        private Main main;
        private List<Weather> weather;
        private long dt;

        public Main getMain() {
            return main;
        }

        public void setMain(Main main) {
            this.main = main;
        }

        public List<Weather> getWeather() {
            return weather;
        }

        public void setWeather(List<Weather> weather) {
            this.weather = weather;
        }

        public long getDt() {
            return dt;
        }

        public void setDt(long dt) {
            this.dt = dt;
        }

        public static class Main {
            private double temp;
            private int pressure;
            private int humidity;

            public double getTemp() {
                return temp;
            }

            public void setTemp(double temp) {
                this.temp = temp;
            }

            public int getPressure() {
                return pressure;
            }

            public void setPressure(int pressure) {
                this.pressure = pressure;
            }

            public int getHumidity() {
                return humidity;
            }

            public void setHumidity(int humidity) {
                this.humidity = humidity;
            }

        }

        public static class Weather {
            private String main;
            private String description;
            private String icon;

            public String getMain() {
                return main;
            }

            public void setMain(String main) {
                this.main = main;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

        }
    }
}

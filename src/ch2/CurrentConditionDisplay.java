import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temp, humidity, heatIndex;
    private Observable weatherData;

    public CurrentConditionDisplay(Observable weatherData){
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    public void display(){
        System.out.println("Current conditions: " + temp
            + "F degrees and " + humidity + "% humidity");
        System.out.println("Heat index: " + heatIndex);
    }

    public void update(Observable obs, Object arg){
        if (obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData)obs;
            this.temp = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.heatIndex = weatherData.getHeatIndex();
            display();
        }
    }
}

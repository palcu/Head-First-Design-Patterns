import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements DisplayElement, Observer{
    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(Observable o){
        o.addObserver(this);
    }

    public void display(){
        System.out.println("Last Pressure: " + lastPressure);
        System.out.println("Current Pressure: " + currentPressure);
    }

    public void update(Observable observable, Object arg){
        if (observable instanceof Observable){
            WeatherData weatherData = (WeatherData) observable;
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
        }
        display();
    }
}

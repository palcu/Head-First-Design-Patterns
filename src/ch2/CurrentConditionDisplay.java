public class CurrentConditionDisplay implements DisplayElement, Observer {
    private float temp, humidity, heatIndex;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void display(){
        System.out.println("Current conditions: " + temp
            + "F degrees and " + humidity + "% humidity");
        System.out.println("Heat index: " + heatIndex);
    }

    public void update(float temp, float humidity, float pressure,
                       float heatIndex){
        this.temp = temp;
        this.humidity = humidity;
        this.heatIndex = heatIndex;
        display();
    }
}

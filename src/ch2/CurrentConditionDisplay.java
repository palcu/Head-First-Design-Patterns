public class CurrentConditionDisplay implements DisplayElement, Observer {
    private float temp, humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void display(){
        System.out.println("Current conditions: " + temp
            + "F degrees and " + humidity + "% humidity");
    }

    public void update(float temp, float humidity, float pressure){
        this.temp = temp;
        this.humidity = humidity;
        display();
    }
}

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(float temperature, float humidity);
}

// Subject class
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setWeatherData(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity);
        }
    }
}

// Concrete observer for phone display
class PhoneDisplay implements Observer {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Phone Display - Temp: " + temperature + ", Humidity: " + humidity);
    }
}

// Concrete observer for computer display
class ComputerDisplay implements Observer {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Computer Display - Temp: " + temperature + ", Humidity: " + humidity);
    }
}

// Client code
public class ObserverPattern {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        
        Observer phoneDisplay = new PhoneDisplay();
        Observer computerDisplay = new ComputerDisplay();

        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(computerDisplay);

        // Weather data changes
        weatherStation.setWeatherData(25.5f, 65.0f);
        weatherStation.setWeatherData(30.0f, 70.0f);
    }
}

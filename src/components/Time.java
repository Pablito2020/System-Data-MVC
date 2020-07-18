package components;

import observer.observers.Observer;

import java.time.LocalTime;

public class Time implements Observer {

    LocalTime time;

    public Time() {
        time = LocalTime.now();
    }

    @Override
    public void update() {
        time = LocalTime.now();
    }

    public String getInformation() {
        return "Current time: " + time;
    }

}

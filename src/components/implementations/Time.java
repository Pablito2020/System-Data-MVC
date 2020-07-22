package components.implementations;

import components.Component;

import java.time.LocalTime;

public class Time implements Component {

    LocalTime time;

    public Time() {
        time = LocalTime.now();
    }

    @Override
    public void update() {
        time = LocalTime.now();
    }

    @Override
    public String getInformation() {
        return "Current time: " + time;
    }

}

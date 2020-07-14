package observers;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import gui.DisplayableObject;
import observables.Observable;

import java.time.LocalTime;

public class Time implements Observer, DisplayableObject {

    LocalTime time;

    public Time(Observable observable) {
        observable.addObserver(this);
        time = LocalTime.now();
    }

    @Override
    public void update() {
        time = LocalTime.now();
    }

    @Override
    public GObject getGraphicalObject() {
        return new GLabel("Current time is: " + time);
    }

}

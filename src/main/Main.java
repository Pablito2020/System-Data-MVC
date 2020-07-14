package main;

import gui.Display;
import gui.button.ClickBehavior;
import observables.SystemObservable;
import observers.Counter;
import observers.Layout;
import observers.Time;
import observers.SystemVersion;

public class Main {

    private final SystemObservable systemObservable = new SystemObservable();
    private Display display;

    public static void main(String[] args) {
        Main program = new Main();
        program.createDisplay();
        program.addObservers();
        program.addObserversToDisplay();
    }

    private void createDisplay() {
        ClickBehavior updateButtonBehavior = buttonUpdateBehavior();
        display = new Display(updateButtonBehavior);
    }

    private void addObservers() {
        Counter counter = new Counter(systemObservable);
        Time time = new Time(systemObservable);
        Layout layout = new Layout(systemObservable);
        SystemVersion systemVersion = new SystemVersion(systemObservable);
    }

    private void addObserversToDisplay() {
        display.start();
        display.addBasicComponents();
        display.addObservers(systemObservable.getObservers());
    }

    // This is where all the magic happens, when the button is pressed, we invoke the update observers method
    // and it updates his observers! 🪄

    private ClickBehavior buttonUpdateBehavior() {
        return () -> {
            systemObservable.updateObservers(); // This updates the observers data
            display.updateObserversData(systemObservable.getObservers()); // This code update the screen data
        };
    }

}

package observers;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import gui.DisplayableObject;
import observables.Observable;

public class Counter implements Observer, DisplayableObject {

    private int counter;

    public Counter(Observable observable) {
        observable.addObserver(this);
        counter = 0;
    }

    @Override
    public void update() {
        counter += 1;
    }

    @Override
    public GObject getGraphicalObject() {
        return new GLabel("You have clicked : " + counter + " times");
    }

}

package observers;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import gui.DisplayableObject;
import observables.Observable;

import static java.lang.System.getProperty;

public class Layout implements Observer, DisplayableObject {

    private String layout;

    public Layout(Observable observable) {
        layout = getProperty("user.language");
        observable.addObserver(this);
    }

    @Override
    public void update() {
        this.layout = getProperty("user.language");
    }

    @Override
    public GObject getGraphicalObject() {
        return new GLabel("Current layout is: " + layout);
    }

}

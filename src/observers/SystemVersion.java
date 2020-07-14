package observers;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import gui.DisplayableObject;
import observables.Observable;

import static java.lang.System.getProperty;

public class SystemVersion implements Observer, DisplayableObject {

    private String operatingSystem;

    public SystemVersion(Observable observable) {
        operatingSystem = getProperty("os.version");
        observable.addObserver(this);
    }

    @Override
    public void update() {
        operatingSystem = getProperty("os.version");
    }


    @Override
    public GObject getGraphicalObject() {
        return new GLabel("Your system version is: " + operatingSystem);
    }

}

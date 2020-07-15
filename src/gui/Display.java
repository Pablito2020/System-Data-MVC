package gui;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import acm.program.ProgramMenuBar;
import gui.button.Button;
import gui.button.ClickBehavior;
import observers.Observer;

import java.util.Arrays;

public class Display extends GraphicsProgram {

    private final Button updateButton;
    private GObject[] observersGraphics = new GObject[0];

    public Display(ClickBehavior clickBehavior) {
        updateButton = new Button((double) getWidth() / 3, (double) getHeight() / 2, "Update Data", clickBehavior);
    }

    public void updateObserversData(Observer[] observers) {
        for (int i = 0; i < observers.length; ++i) {
            Observer currentObserver = observers[i];
            if (currentObserver instanceof DisplayableObject && observersGraphics[i] instanceof GLabel) {
                double x = observersGraphics[i].getX();
                double y = observersGraphics[i].getY();
                remove(observersGraphics[i]);
                observersGraphics[i] = ((DisplayableObject) currentObserver).getGraphicalObject();
                add(observersGraphics[i], x, y);
            }
        }
    }

    public void addObservers(Observer[] observers) {
        for (Observer observer : observers) {
            if (observer instanceof DisplayableObject) {
                GObject graphicalObject = (((DisplayableObject) observer).getGraphicalObject());
                addObserverToScreen(graphicalObject);
            }
        }
    }

    private void addObserverToScreen(GObject graphicalObject) {
        int length = observersGraphics.length + 1;
        observersGraphics = Arrays.copyOf(observersGraphics, length);
        observersGraphics[length - 1] = graphicalObject;
        add(observersGraphics[length - 1], (double) getWidth() / 2, 50 * length);
    }

    public void addBasicComponents() {
        setTitle("Application Context Information:");
        add(updateButton, (double) getWidth() / 3, (double) getHeight() / 2);
    }

    @Override
    protected ProgramMenuBar createMenuBar() {
        return null;
    }

}

package mvc.view;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import mvc.controller.Controller;
import mvc.model.Model;
import observables.Observable;
import observers.Observer;

import java.awt.event.MouseEvent;

public class Display extends GraphicsProgram implements Observer, View {

    private final Controller controller;
    private final Model model;

    private Button clickButton;
    private GLabel counter;
    private GLabel keyboardLayout;
    private GLabel systemVersion;
    private GLabel time;

    public Display(Controller controller, Model model) {
        this.controller = controller;
        this.model = model;
        ((Observable) model).addObserver(this);
        this.createElements();
        this.addMouseListeners();
    }

    @Override
    public void addElements() {
        add(clickButton, (double) getWidth() / 3, (double) getHeight() / 2);
        add(counter, (double) getWidth() / 2, (double) getHeight() * 1 / 6);
        add(keyboardLayout, (double) getWidth() / 2, (double) getHeight() * 2 / 6);
        add(systemVersion, (double) getWidth() / 2, (double) getHeight() * 3 / 6);
        add(time, (double) getWidth() / 2, (double) getHeight() * 4 / 6);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (clickButton.contains(e.getX(), e.getY())) controller.updateButtonClicked();
    }

    @Override
    public void update() {
        counter.setLabel(model.getCounter());
        keyboardLayout.setLabel(model.getKeyboard());
        systemVersion.setLabel(model.getSystemInformation());
        time.setLabel(model.getTime());
    }

    private void createElements() {
        clickButton = new Button("Click me", (double) getWidth() / 3, (double) getHeight() / 2);
        counter = new GLabel(model.getCounter(), (double) getWidth() / 2, (double) getHeight() * 1 / 6);
        keyboardLayout = new GLabel(model.getKeyboard(), (double) getWidth() / 2, (double) getHeight() * 2 / 6);
        systemVersion = new GLabel(model.getSystemInformation(), (double) getWidth() / 2, (double) getHeight() * 3 / 6);
        time = new GLabel(model.getTime(), (double) getWidth() / 2, (double) getHeight() * 4 / 6);
    }

}

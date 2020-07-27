package mvc.view;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import components.Components;
import mvc.controller.Controller;
import mvc.model.Model;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Display extends GraphicsProgram implements View {

    private final Controller controller;
    private final Model model;

    private Button clickButton;
    private ArrayList<GLabel> labels;

    public Display(Controller controller, Model model) {
        this.controller = controller;
        this.model = model;
        this.labels = new ArrayList<>();
        model.addObserver(this);
        this.createElements();
        this.addMouseListeners();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (clickButton.contains(e.getX(), e.getY()))
            controller.updateButtonClicked();
    }

    @Override
    public void update() {
        int x = 0;
        for(Components component : Components.values()) {
            GLabel currentLabel = labels.get(x);
            currentLabel.setLabel(model.getInformation(component));
            x += 1;
        }
    }

    private void createElements() {
        createButtons();
        createLabels();
    }

    private void createButtons() {
        clickButton = new Button("Click me", (double) getWidth() / 3, (double) getHeight() / 2);
    }

    private void createLabels() {
        int x = 1;
        for(Components component : Components.values()) {
            labels.add(new GLabel(model.getInformation(component), (double) getWidth() / 2, (double) getHeight() * x / 6 ));
            x += 1;
        }
    }

    @Override
    public void addElements() {
        addButtons();
        addLabels();
    }

    private void addButtons() {
        add(clickButton, (double) getWidth() / 3, (double) getHeight() / 2);
    }

    private void addLabels() {
        int x = 1;
        for (GLabel label : labels) {
            add(label, (double) getWidth() / 2, (double) getHeight() * x / 6);
            x += 1;
        }
    }

}

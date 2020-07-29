package mvc.view.components;

import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import components.Components;
import mvc.model.Model;

import java.util.ArrayList;

public class AllComponentsTextContainer implements ComponentsTextContainer {

    private GCanvas canvas;
    private Model model;
    private ArrayList<GLabel> labels;

    public AllComponentsTextContainer(GCanvas canvas, Model model) {
        this.canvas = canvas;
        this.model = model;
        this.labels = new ArrayList<>();
        this.createLabels();
    }

    private void createLabels() {
        int x = 1;
        for(Components component : Components.values()) {
            labels.add(new GLabel(model.getInformation(component), (double) canvas.getWidth() / 2, (double) canvas.getHeight() * x / 6 ));
            x += 1;
        }
    }

    @Override
    public void addComponentsCanvas() {
        int x = 1;
        for (GLabel label : labels) {
            canvas.add(label, (double) canvas.getWidth() / 2, (double) canvas.getHeight() * x / 6);
            x += 1;
        }
    }

    @Override
    public void removeComponentsCanvas() {
        for(GLabel component : labels)
            canvas.remove(component);
    }

    @Override
    public void updateComponentsLabels() {
        int x = 0;
        for(Components component : Components.values()) {
            GLabel currentLabel = labels.get(x);
            currentLabel.setLabel(model.getInformation(component));
            x += 1;
        }
    }

}

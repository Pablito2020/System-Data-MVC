package mvc.view;

import acm.program.GraphicsProgram;
import mvc.controller.Controller;
import mvc.model.Model;
import mvc.view.buttons.ButtonsContainer;
import mvc.view.buttons.ButtonsImp;
import mvc.view.components.AllComponentsTextContainer;
import mvc.view.components.ComponentsTextContainer;

public class Display extends GraphicsProgram implements View {

    private final ComponentsTextContainer componentsContainer;
    private final ButtonsContainer buttonsContainer;


    public Display(Controller controller, Model model) {
        model.addObserver(this);
        this.componentsContainer = new AllComponentsTextContainer(getGCanvas(), model);
        this.buttonsContainer = new ButtonsImp(getGCanvas(), controller);
    }

    @Override
    public void update() {
        componentsContainer.updateComponentsLabels();
    }

    @Override
    public void addElements() {
        buttonsContainer.addButtonsCanvas();
        componentsContainer.addComponentsCanvas();
    }

}

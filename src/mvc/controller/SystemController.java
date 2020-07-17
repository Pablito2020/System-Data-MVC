package mvc.controller;

import mvc.model.Model;
import mvc.view.Display;

public class SystemController implements Controller {

    private Model model;
    private Display display;

    public SystemController(Model model) {
        this.model = model;
        this.display = new Display(this, model);
        display.start();
        display.addElements();
    }

    @Override
    public void updateButtonClicked() {
        model.updateData();
    }

}

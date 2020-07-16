package mvc.controler;

import mvc.Controler;
import mvc.Model;
import mvc.view.Display;

public class SystemControler implements Controler {

    private Model model;
    private Display display;

    public SystemControler(Model model) {
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

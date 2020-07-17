package main;

import mvc.Controller;
import mvc.controller.SystemController;
import mvc.Model;
import mvc.model.SystemModel;

public class Main {


    public static void main(String[] args) {
        Main program = new Main();
        program.initialize();
    }

    private void initialize() {
        Model model = new SystemModel();
        Controller controller = new SystemController(model);
    }

}

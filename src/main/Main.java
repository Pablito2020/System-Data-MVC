package main;

import mvc.Controler;
import mvc.controler.SystemControler;
import mvc.Model;
import mvc.model.SystemModel;

public class Main {


    public static void main(String[] args) {
        Main program = new Main();
        program.initialize();
    }

    private void initialize() {
        Model model = new SystemModel();
        Controler controler = new SystemControler(model);
    }

}

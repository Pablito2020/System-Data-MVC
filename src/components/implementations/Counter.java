package components.implementations;

import components.Component;

public class Counter implements Component {

    private int counter;

    public Counter() {
        counter = 0;
    }

    @Override
    public void update() {
        counter += 1;
    }

    @Override
    public String getInformation() {
        return "You have clicked: " + counter;
    }

}

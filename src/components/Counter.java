package components;

import observers.Observer;

public class Counter implements Observer {

    private int counter;

    public Counter() {
        counter = 0;
    }

    @Override
    public void update() {
        counter += 1;
    }

    public String getInformation() {
        return "You have clicked: " + counter;
    }

}

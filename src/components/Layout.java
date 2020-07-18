package components;

import observer.observers.Observer;

import static java.lang.System.getProperty;

public class Layout implements Observer {

    private String layout;

    public Layout() {
        layout = getProperty("user.language");
    }

    @Override
    public void update() {
        this.layout = getProperty("user.language");
    }

    public String getInformation() {
        return "Language: " + layout;
    }

}

package components.implementations;

import components.Component;

import static java.lang.System.getProperty;

public class Layout implements Component {

    private String layout;

    public Layout() {
        layout = getProperty("user.language");
    }

    @Override
    public void update() {
        this.layout = getProperty("user.language");
    }

    @Override
    public String getInformation() {
        return "Language: " + layout;
    }

}

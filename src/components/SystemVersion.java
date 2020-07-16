package components;

import observers.Observer;

import static java.lang.System.getProperty;

public class SystemVersion implements Observer {

    private String operatingSystem;

    public SystemVersion() {
        operatingSystem = getProperty("os.version");
    }

    @Override
    public void update() {
        operatingSystem = getProperty("os.version");
    }

    public String getInformation() {
        return "Linux kernel is: " + operatingSystem;
    }

}

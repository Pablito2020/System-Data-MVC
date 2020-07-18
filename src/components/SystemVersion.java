package components;

import observer.observers.Observer;

import static java.lang.System.getProperty;

public class SystemVersion implements Observer {

    private String operatingSystemVersion;

    public SystemVersion() {
        operatingSystemVersion = getProperty("os.version");
    }

    @Override
    public void update() {
        operatingSystemVersion = getProperty("os.version");
    }

    public String getInformation() {
        String currentOS = System.getProperty("os.name");
        return currentOS.equals("Linux") ? "Linux kernel version : " + operatingSystemVersion : currentOS + " version is: " + operatingSystemVersion;
    }

}

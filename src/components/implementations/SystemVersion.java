package components.implementations;

import components.Component;

import static java.lang.System.getProperty;

public class SystemVersion implements Component {

    private String operatingSystemVersion;

    public SystemVersion() {
        operatingSystemVersion = getProperty("os.version");
    }

    @Override
    public void update() {
        operatingSystemVersion = getProperty("os.version");
    }

    @Override
    public String getInformation() {
        String currentOS = System.getProperty("os.name");
        return currentOS.equals("Linux") ? "Linux kernel version : " + operatingSystemVersion : currentOS + " version is: " + operatingSystemVersion;
    }

}

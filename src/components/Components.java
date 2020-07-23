package components;

import components.implementations.Counter;
import components.implementations.Layout;
import components.implementations.SystemVersion;
import components.implementations.Time;

public enum Components {

    COUNTER(Counter.class), LAYOUT(Layout.class), SYSTEM_VERSION(SystemVersion.class), TIME(Time.class);

    private final Class currentClass; // Needed for checking if an observer object is an instance of some Component

    Components(Class componentClass) {
        this.currentClass = componentClass;
    }

    public Class returnClass() {
        return currentClass;
    }

}

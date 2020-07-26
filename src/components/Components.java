package components;

import components.implementations.*;

import java.lang.reflect.InvocationTargetException;

public enum Components {

    COUNTER(Counter.class), LAYOUT(Layout.class), SYSTEM_VERSION(SystemVersion.class), TIME(Time.class), TIMER(Timer.class);

    private final Class currentClass; // Needed for checking if an observer object is an instance of some Component

    Components(Class componentClass) {
        this.currentClass = componentClass;
    }

    public Class getComponentClass() {
        return currentClass;
    }

    // TODO: This method needs improvement for the try/catch block!
    public Component getComponentInstance() {
        try {
            return (Component) currentClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No component named " + currentClass.getName());
    }

}

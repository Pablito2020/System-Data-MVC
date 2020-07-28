package components;

import components.implementations.*;

import java.lang.reflect.InvocationTargetException;

public enum Components {

    COUNTER(Counter.class), LAYOUT(Layout.class), SYSTEM_VERSION(SystemVersion.class), TIME(Time.class), TIMER(Timer.class);

    private final Class<? extends Component> currentClass; // Needed for checking if an observer object is an instance of some Component

    Components(Class<? extends Component> componentClass) {
        this.currentClass = componentClass;
    }

    public Class<? extends Component> getComponentClass() {
        return currentClass;
    }

    public Component getComponentInstance() {
        try {
            return currentClass.getDeclaredConstructor().newInstance(); // Thanks StackOverFlow 🙃
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No component named " + currentClass.getName());
    }

}

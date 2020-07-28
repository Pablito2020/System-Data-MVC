package mvc.model.componentkeeper;

import components.Component;
import components.Components;

import java.util.ArrayList;

public class ArrayKeeper implements ComponentKeeper {

    private final ArrayList<Component> components;

    public ArrayKeeper() {
        this.components = new ArrayList<>();
    }

    @Override
    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public void updateComponents() {
        for (Component currentComponent : components)
            currentComponent.update();
    }

    @Override
    public String getInformation(Components component) {
        Class<? extends Component> componentClass = component.getComponentClass();
        for (Component currentComponent : components) {
            if (componentClass.isInstance(currentComponent))
                return currentComponent.getInformation();
        }
        throw new IllegalArgumentException("You have no component named " + component);
    }

}

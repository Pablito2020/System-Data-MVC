package mvc.model;

import components.Component;
import components.Components;

import java.util.ArrayList;
import java.util.Iterator;

public class ComponentsBag {

    private final ArrayList<Component> components;

    public ComponentsBag() {
        this.components = new ArrayList<>();
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void updateComponents() {
        for (Component currentComponent : components)
            currentComponent.update();
    }

    public String getInfo(Components component) {
        Class currentClass = component.returnClass();
        for (Component currentComponent : components) {
            if (currentClass.isInstance(currentComponent))
                return currentComponent.getInformation();
        }
        throw new IllegalArgumentException("You have no component named " + component);
    }

}

package mvc.model;

import components.*;
import components.implementations.Counter;
import components.implementations.Layout;
import components.implementations.SystemVersion;
import components.implementations.Time;

import java.util.ArrayList;
import java.util.Iterator;

public class ComponentsBag {

    private ArrayList<Component> components;

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

    // I don't really like this method but, working with the instanceof operator was a pain ...

    public String getInfo(Components component) {
        Iterator<Component> componentIterator = components.iterator();
        while(componentIterator.hasNext() && component != null) {
            Component currentComponent = componentIterator.next();
            if(currentComponent instanceof Counter && component == Components.COUNTER) return currentComponent.getInformation();
            else if (currentComponent instanceof Layout && component == Components.LAYOUT) return currentComponent.getInformation();
            else if (currentComponent instanceof SystemVersion && component == Components.SYSTEM_VERSION) return currentComponent.getInformation();
            else if (currentComponent instanceof Time && component == Components.TIME) return currentComponent.getInformation();
        }
        throw new IllegalArgumentException("You have no component named " + component);
    }

}

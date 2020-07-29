package mvc.model;

import components.Components;
import mvc.model.componentcontainer.ComponentArrayContainer;
import mvc.model.componentcontainer.ComponentContainer;
import observer.observables.Observable;
import observer.observables.ObservableArray;
import observer.observers.Observer;

public class SystemModel implements Model {

    private final Observable displayObservable;
    private final ComponentContainer componentContainer;

    public SystemModel() {
        this.componentContainer = new ComponentArrayContainer();
        this.displayObservable = new ObservableArray();
        this.addComponents();
    }

    private void addComponents() {
        for (Components component : Components.values())
            componentContainer.addComponent(component.getComponentInstance());
    }

    @Override
    public void updateData() {
        componentContainer.updateComponents();
        displayObservable.notifyObservers();
    }

    @Override
    public String getInformation(Components component) {
        return componentContainer.getInformation(component);
    }

    // Add Observers or delete Observers

    @Override
    public void addObserver(Observer observer) {
        displayObservable.addObserver(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        displayObservable.deleteObserver(observer);
    }

    @Override
    public void notifyObservers() {
        displayObservable.notifyObservers();
    }

    @Override
    public void deleteObserver(int index) {
        displayObservable.deleteObserver(index);
    }

}

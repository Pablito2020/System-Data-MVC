package mvc.model;

import components.Components;
import mvc.model.componentkeeper.ArrayKeeper;
import mvc.model.componentkeeper.ComponentKeeper;
import observer.observables.Observable;
import observer.observables.ObservableArray;
import observer.observers.Observer;

public class SystemModel implements Model {

    private final Observable displayObservable;
    private final ComponentKeeper components;

    public SystemModel() {
        this.components = new ArrayKeeper();
        this.displayObservable = new ObservableArray();
        this.addComponents();
    }

    private void addComponents() {
        for (Components component : Components.values())
            components.addComponent(component.getComponentInstance());
    }

    @Override
    public void updateData() {
        components.updateComponents();
        displayObservable.notifyObservers();
    }

    @Override
    public String getInformation(Components component) {
        return components.getInformation(component);
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

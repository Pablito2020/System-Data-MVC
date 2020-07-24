package mvc.model;

import components.Components;
import components.implementations.*;
import observer.observables.Observable;
import observer.observables.ObservableArray;
import observer.observers.Observer;

public class SystemModel extends ComponentsBag implements Model {

    private final Observable displayObservable;
    private final ComponentsBag components;

    public SystemModel() {
        this.components = new ComponentsBag();
        this.displayObservable = new ObservableArray();
        this.addComponents();
    }

    private void addComponents() {
        components.addComponent(new Counter());
        components.addComponent(new Layout());
        components.addComponent(new SystemVersion());
        components.addComponent(new Time());
        components.addComponent(new TimerComp());
    }

    @Override
    public void updateData() {
        components.updateComponents();
        displayObservable.notifyObservers();
    }

    @Override
    public String getInfo(Components component) {
        return components.getInfo(component);
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

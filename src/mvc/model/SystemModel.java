package mvc.model;

import mvc.Model;
import observers.Observer;
import components.Counter;
import components.Layout;
import components.SystemVersion;
import components.Time;
import observables.Observable;
import observables.BasicObservable;

public class SystemModel implements Model, Observable {

    private Observable displayObservable;
    private Observable componentsObservable;

    private Counter counter;
    private Layout layout;
    private SystemVersion systemVersion;
    private Time time;

    public SystemModel() {
        this.displayObservable = new BasicObservable();
        this.componentsObservable = new BasicObservable();
        this.counter = new Counter();
        this.layout = new Layout();
        this.systemVersion = new SystemVersion();
        this.time = new Time();
        addComponentsObservers();
    }

    private void addComponentsObservers() {
        componentsObservable.addObserver(counter);
        componentsObservable.addObserver(layout);
        componentsObservable.addObserver(systemVersion);
        componentsObservable.addObserver(time);
    }

    // Update data method (called from the controler)

    @Override
    public void updateData() {
        componentsObservable.notifyObservers();
        displayObservable.notifyObservers();
    }

    // Getters

    @Override
    public String getCounter() {
        return counter.getInformation();
    }

    @Override
    public String getKeyboard() {
        return layout.getInformation();
    }

    @Override
    public String getSystemInformation() {
        return systemVersion.getInformation();
    }

    @Override
    public String getTime() {
        return time.getInformation();
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

package mvc.model;

import observer.observers.Observer;
import components.Counter;
import components.Layout;
import components.SystemVersion;
import components.Time;
import observer.observables.Observable;
import observer.observables.BasicObservable;

public class SystemModel implements Model {

    private Observable displayObservable;
    private Observable modelObservable;

    private Counter counter;
    private Layout layout;
    private SystemVersion systemVersion;
    private Time time;

    public SystemModel() {
        initializeObservables();
        initializeComponents();
        makeComponentsObserversOfModel();
    }

    private void initializeObservables() {
        this.displayObservable = new BasicObservable();
        this.modelObservable = new BasicObservable();
    }

    private void initializeComponents() {
        this.counter = new Counter();
        this.layout = new Layout();
        this.systemVersion = new SystemVersion();
        this.time = new Time();
    }

    private void makeComponentsObserversOfModel() {
        modelObservable.addObserver(counter);
        modelObservable.addObserver(layout);
        modelObservable.addObserver(systemVersion);
        modelObservable.addObserver(time);
    }

    // Update data method (called from the controller)

    @Override
    public void updateData() {
        modelObservable.notifyObservers();
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

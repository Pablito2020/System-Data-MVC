package observer.observables;

import observer.observers.Observer;

import java.util.ArrayList;

public class ObservableArrayList implements Observable {

    private final ArrayList<Observer> observers;

    public ObservableArrayList() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers)
            observer.update();
    }

    @Override
    public void deleteObserver(int index) {
        observers.remove(index);
    }

}

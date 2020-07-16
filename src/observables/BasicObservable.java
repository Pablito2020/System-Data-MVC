package observables;

import observers.Observer;

public class BasicObservable implements Observable {

    private Observer[] observers;

    public BasicObservable() {
        this.observers = new Observer[0];
    }

    @Override
    public void addObserver(Observer observer) {
        int length = observers.length + 1;
        Observer[] newObservers = new Observer[length];
        for (int i = 0; i < observers.length; ++i) {
            newObservers[i] = observers[i];
        }
        newObservers[newObservers.length - 1] = observer;
        observers = newObservers;
    }

    @Override
    public void deleteObserver(Observer observer) {
        int length = observers.length - 1;
        Observer[] newObservers = new Observer[length];
        if (hasObserver(observer)) copyObservers(newObservers, observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void deleteObserver(int index) {
        if (index < 0 || index >= observers.length) return;
        Observer[] newObservers = new Observer[observers.length - 1];
        for (int i = 0; i < observers.length; ++i) {
            if (index != i) newObservers[i] = observers[i];
        }
        observers = newObservers;
    }

    // Private auxiliary methods

    private boolean hasObserver(Observer observer) {
        for (Observer currentObserver : observers) if (observer.equals(currentObserver)) return true;
        return false;
    }

    private void copyObservers(Observer[] newObservers, Observer observer) {
        for (int i = 0; i < observers.length; ++i) {
            if (!observer.equals(observers[i])) newObservers[i] = observers[i];
        }
    }

}

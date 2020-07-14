package observables;

import observers.Observer;

/*
    TODO: In this case, an ArrayList object would be way better, but , for now I don't really know how to work with it, so I decided to keep an array.
*/

public class SystemObservable implements Observable {

    private Observer[] observers;

    public SystemObservable() {
        this.observers = new Observer[0];
    }

    public Observer[] getObservers() {
        return observers;
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
    public void updateObservers() {
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

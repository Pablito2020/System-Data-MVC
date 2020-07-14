package observables;

import observers.Observer;

public interface Observable {
    void addObserver(Observer observer);
    void deleteObserver(int index);
    void deleteObserver(Observer observer);
    void updateObservers();
}

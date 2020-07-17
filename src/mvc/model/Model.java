package mvc.model;

import observables.Observable;

public interface Model extends Observable {
    void updateData();
    String getCounter();
    String getKeyboard();
    String getSystemInformation();
    String getTime();
}

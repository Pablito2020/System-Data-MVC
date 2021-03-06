package mvc.model;

import components.Components;
import observer.observables.Observable;

public interface Model extends Observable {

    void updateData();

    String getInformation(Components component);

}

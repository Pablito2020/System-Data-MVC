package components;

import observer.observers.Observer;

public interface Component extends Observer {
    String getInformation();
}

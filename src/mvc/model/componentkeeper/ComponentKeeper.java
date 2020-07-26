package mvc.model.componentkeeper;

import components.Component;
import components.Components;

public interface ComponentKeeper {

    void addComponent(Component component);

    void updateComponents();

    String getInformation(Components component);

}

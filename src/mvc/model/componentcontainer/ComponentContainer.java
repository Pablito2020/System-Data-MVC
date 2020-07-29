package mvc.model.componentcontainer;

import components.Component;
import components.Components;

public interface ComponentContainer {

    void addComponent(Component component);

    void updateComponents();

    String getInformation(Components component);

}

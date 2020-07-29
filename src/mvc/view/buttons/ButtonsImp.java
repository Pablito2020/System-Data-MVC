package mvc.view.buttons;

import acm.graphics.GCanvas;
import mvc.controller.Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonsImp implements ButtonsContainer {

    private final GCanvas canvas;
    private final Button clickButton;
    private final Controller controller;

    public ButtonsImp(GCanvas canvas, Controller controller) {
        this.canvas = canvas;
        this.clickButton = new Button("Click me", (double) canvas.getWidth() / 3, (double) canvas.getHeight() / 2);
        this.controller = controller;
        this.addMouseListeners();
    }

    @Override
    public void addButtonsCanvas() {
        canvas.add(clickButton, (double) canvas.getWidth() / 3, (double) canvas.getHeight() / 2);
    }

    @Override
    public void removeButtonsCanvas() {
        canvas.remove(clickButton);
    }

    private void addMouseListeners() {
        clickButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                controller.updateButtonClicked();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
    }
}

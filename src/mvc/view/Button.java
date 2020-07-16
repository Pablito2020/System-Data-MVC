package mvc.view;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRectangle;
import acm.graphics.GRoundRect;

import java.awt.*;

public class Button extends GCompound {

    private static final double PADDING = 0.1;

    private GRoundRect button;
    private GLabel buttonText;
    private final String text;

    private Color normalTextColor = Color.WHITE;
    private Color normalButtonColor = Color.RED;

    private Color selectionTextColor = Color.BLACK;
    private Color selectionButtonColor = Color.GREEN;

    public Button(String text, double x, double y) {
        this.text = text;
        this.createText();
        this.createRectangle(x, y);
        this.colorizeButton();
        this.fusionRectangleAndText(x, y);
    }

    public Color getRectangleColor() {
        return button.getColor();
    }

    public Color getTextColor() {
        return buttonText.getColor();
    }

    public void setNormalTextColor(Color color) {
        normalTextColor = color;
    }

    public void setSelectionTextColor(Color color) {
        selectionTextColor = color;
    }

    public void setNormalRectangleColor(Color color) {
        normalButtonColor = color;
    }

    public void setSelectionButtonColor(Color color) {
        selectionButtonColor = color;
    }

    // Auxiliary private methods

    private void createRectangle(double x, double y) {
        GRectangle rectangleFromText = buttonText.getBounds();
        double width = rectangleFromText.getWidth() * PADDING * 2 + rectangleFromText.getWidth();
        double height = rectangleFromText.getHeight() * PADDING * 2 + rectangleFromText.getHeight();
        button = new GRoundRect(x, y, width, height);
    }

    private void createText() {
        buttonText = new GLabel(text);
    }

    private void fusionRectangleAndText(double x, double y) {
        add(button);
        add(buttonText, x + button.getWidth() * PADDING, y + buttonText.getHeight());
    }

    private void colorizeButton() {
        button.setFilled(true);
        setNormalColors();
    }

    private void setNormalColors() {
        button.setFillColor(normalButtonColor);
        buttonText.setColor(normalTextColor);
    }

    private void setSelectionColors() {
        button.setFillColor(selectionButtonColor);
        buttonText.setColor(selectionTextColor);
    }

}

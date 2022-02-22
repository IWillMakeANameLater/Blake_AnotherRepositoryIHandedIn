package com.modules.module4;

public abstract class TwoDShape {
    private double width;
    private double height;
    private Colour colour;

    /**
     * A default constructor for TwoDShape when given no arguments.
     * The width and the height are set to 1, and the colour is treated as "None".
     */
    public TwoDShape(){
        this.width = 1;
        this.height = 1;
        this.colour = Colour.NONE;
    }

    /**
     * Creates a TwoDShape given a specified width, height and color.
     * @param width - Width of the shape
     * @param height - Height of the shape
     * @param color - Color of the shape.
     */
    public TwoDShape(double width, double height, Colour color){
        this.width = width;
        this.height = height;
        this.colour = color;
    }

    /**
     * @return the shape's width.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the shape's width.
     * @param width - the width to adjust to.
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return the shape's height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the shape's height.
     * @param height - the height to adjust to.
     */
    public void setHeight(double height){
        this.height = height;
    }

    /**
     * Gets the area of the shape. Method varies depending on the shape.
     * @return the area of the shape.
     */
    public abstract double getArea();
}

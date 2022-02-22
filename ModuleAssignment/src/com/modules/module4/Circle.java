package com.modules.module4;

public class Circle extends TwoDShape {
    public final double PI = 3.14159265359;

    private double radius;

    /**
     * Creates a circle with a specified radius and colour. Height and Width are treated as "1" since it does not use those fields.
     * @param radius - Radius of the circle
     * @param colour - Color of the shape
     */
    public Circle(double radius, Colour colour){
        super(1,1, colour);
        this.radius = radius;
    }

    /**
     * Sets the circle's radius.
     * @param radius - radius to change to.
     */
    public void setRadius(double radius){
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return PI * Math.pow(this.radius, 2);
    }

    /**
     * @return Circle and its radius as a string
     */
    @Override
    public String toString(){
        return "Circle -> Radius: " + this.radius;
    }   
}

package com.modules.module2;

public class Circle extends TwoDShape{
    public final double PI = 3.14159265359;

    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return PI * Math.pow(this.radius, 2);
    }

    @Override
    public String toString(){
        return "Circle -> Radius: " + this.radius;
    }
}

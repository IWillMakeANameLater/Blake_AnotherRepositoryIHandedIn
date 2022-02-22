package com.modules.module1;

public class TwoDShape {
    private double width;
    private double height;

    public TwoDShape(){
        this.width = 1;
        this.height = 1;
    }

    public TwoDShape(double width, double height){
        this.width = width;
        this.height = height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getArea(){
        return this.width * this.height;
    }
}

package com.modules.module2;

public class Triangle extends TwoDShape {
    double side1;
    double side2;
    double side3;

    public Triangle(double width, double height){
        super(width, height);
    }

    public Triangle(double side1, double side2, double side3){
        super(side1, 0);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        double trigHeight_Side1 = heronsHeight();
        super.setHeight(trigHeight_Side1);
    }

    private double heronsHeight(){
        double semiPerimeter = (this.side1 + this.side2 + this.side3) / 2;
        double trigArea = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
        return (trigArea * 2) / side1; // A = bh/2 -> 2A = bh -> 2A/b = h
    }

    @Override
    public double getArea(){
        return side1 * heronsHeight() / 2;
    }

    @Override
    public String toString(){
        return "Triangle -> Side 1: "+this.side1+" | Side 2: " + this.side2 + " | Side 3: " + this.side3;
    }
}

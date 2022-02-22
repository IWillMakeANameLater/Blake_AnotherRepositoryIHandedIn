package com.modules.module4;

public class Triangle extends TwoDShape implements Rotate {
    private double side1;
    private double side2;
    private double side3;

    /**
     * Constructs a new triangle given a specified
     * @param width - Width of the triangle, or the base
     * @param height - Height of the triangle
     * @param colour - Color of the shape
     */
    public Triangle(double width, double height, Colour colour){
        super(width, height, colour);
    }

    /**
     * An alternative constructor that constructs a Triangle from 3 given sides.
     * Uses Heron's Formula to find the triangle's Area, which is then used to get the triangle's height.
     * The first side given is treated as the width/the base of the triangle.
     *
     * @param side1 - The length of the first side. This is also treated as the base/the width.
     * @param side2 - The length of the second side
     * @param side3 - The length of the third side
     * @param colour - color of the shape
     */
    public Triangle(double side1, double side2, double side3, Colour colour){
        super(side1, 0, colour);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        double trigHeight_Side1 = heronsHeight();
        super.setHeight(trigHeight_Side1);
    }

    /**
     * Given the 3 sides of the triangle, uses Heron's formula to get the Area of the triangle.
     * Then, uses the area to get the height of the triangle, treating the first side as the base of the triangle.
     * @return the height of the triangle as a double
     */
    private double heronsHeight(){
        double semiPerimeter = (this.side1 + this.side2 + this.side3) / 2;
        double trigArea = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
        return (trigArea * 2) / side1; // A = bh/2 -> 2A = bh -> 2A/b = h
    }

    /**
     * Get's the triangle's area. This is calculated by the base of the triangle multiplied by the height of the triangle divided by 2.
     * @return The triangle's area as a double.
     */
    @Override
    public double getArea(){
        return super.getWidth() * super.getHeight() / 2;
    }

    /**
     * @return Triangle and the lengths of each of its 3 sides
     */
    @Override
    public String toString(){
        return "Triangle -> Side 1: "+this.side1+" | Side 2: " + this.side2 + " | Side 3: " + this.side3;
    }

    @Override
    public void rotate90() {

    }

    @Override
    public void rotate180() {

    }

    @Override
    public void rotate(double degree) {
        
    }
}

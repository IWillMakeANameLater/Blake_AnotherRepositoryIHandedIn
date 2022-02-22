package com.modules.module4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaTest {

    /*
        This test is to make sure that the getArea method of the Triangle is calculating area properly.
        The formula of an area of a Triangle is bh/2.

        b - base
        h - height

        Since this is a shape, the base and the height should not be negative.

        Cases -
        Positive numbers for base and height - small, big, with decimals, etc.
        Special cases - 0 & 1
     */
    @Test
    void getArea() {
        // Initial triangle
        Triangle testTriangle = new Triangle(1,1, Colour.NONE);

        // Positive cases
        testTriangle.setHeight(2);
        testTriangle.setWidth(2);
        assertEquals(2, testTriangle.getArea(), 0.001);

        testTriangle.setHeight(1004120);
        testTriangle.setWidth(4024100);
        assertEquals(2.020339646e+12, testTriangle.getArea(), 10);

        testTriangle.setWidth(0.01);
        testTriangle.setHeight(1.24);
        assertEquals(6.2e-3, testTriangle.getArea(), 0.1e-6);

        // Boundary cases
        testTriangle.setHeight(1);
        testTriangle.setWidth(8);
        assertEquals(4, testTriangle.getArea(), 0.001);

        testTriangle.setWidth(0);
        testTriangle.setHeight(1);
        assertEquals(0, testTriangle.getArea(), 0);
    }
}
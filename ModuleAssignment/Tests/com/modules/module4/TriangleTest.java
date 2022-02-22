package com.modules.module4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    /*
        This test will test the Triangle's heronHeight() method to make sure it is working properly.

        The method first finds the area using Heron's Formula.

        Heron's Formula is as follows:
        A = ( S ( S - a )( S - b )( S - C ) ) ^ 1/2

        A = area of the triangle
        S - Semiperimeter of triangle ( Perimeter divided by 2 )
        a - side 1 of the triangle
        b - side 2 of the triangle
        c - side 3 of the triangle

        After finding the area, the method then derives the height of the triangle from the area, treating side 1 as the base.

        Area of the triangle:
        A = bh/2

        Which is changed in relation to h, height
        2A = bh
        2A/b = h

        Since this is a shape, all sides should not be negative.
        Side length should also not be 0 as that would be an open/incomplete triangle and not one with 3 sides.

        Cases
        Positive sides - small, large, with decimals

        Test will be done by creating the triangle, then getting the height of the triangle and comparing that to an expected value
     */

    @Test
    void testHeronsHeight(){
        //Positive Side counts

        // Small - Special Case of 1
        Triangle testTriangle0 = new Triangle(1,1,1, Colour.NONE);
        assertEquals(0.86602540378, testTriangle0.getHeight(), 0.00001);

        // Small
        Triangle testTriangle1 = new Triangle(5, 12, 13, Colour.NONE);
        assertEquals(12, testTriangle1.getHeight(), 0.1);

        // Large
        Triangle testTriangle2 = new Triangle(500,300,400, Colour.NONE);
        assertEquals(240, testTriangle2.getHeight(), 0.1);

        // Decimals
        Triangle testTriangle3 = new Triangle(51.12, 42.01, 92.4, Colour.NONE);
        assertEquals(10.4664283915, testTriangle3.getHeight(), 0.001);

    }
}
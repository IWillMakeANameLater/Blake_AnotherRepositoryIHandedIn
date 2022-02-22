package com.modules.module4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    /*
        Area of a circle is based on its radius.
        Since this is a shape, the radius should not be less than 0.

        Cases :
        Positive Numbers - Large, Small, With Decimals
        Boundary Case - 0
     */

    @Test
    void getArea() {
        // Initial state
        Circle testCircle = new Circle(1, Colour.NONE);

        // Positive Numbers
        assertEquals(3.14159265359, testCircle.getArea(), 0); // 1^2 * 3.14159265359 = 3.14159265359

        testCircle.setRadius(33123);
        assertEquals(3.44674537807660978311e+9, testCircle.getArea(), 1); // 33123^2 * 3.14159265359 = 104058.9734648616

        testCircle.setRadius(0.01);
        assertEquals(3.14159265359e-4, testCircle.getArea()); // 0.01^2 * 3.14159265359 = 0.0314159265359

        // Boundary Case
        testCircle.setRadius(0);
        assertEquals(0, testCircle.getArea(), 0); // 3.14159265359 * 0^2 = 0
    }
}
import com.modules.module2.Circle;
import com.modules.module2.Triangle;
import com.modules.module2.TwoDShape;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<TwoDShape> shapes = new ArrayList<>();
        shapes.add(new Triangle(1,1,1));
        shapes.add(new Triangle(2,3,4));
        shapes.add(new Triangle(3,4,5));
        shapes.add(new Circle(1));
        shapes.add(new Circle(3));
        shapes.add(new Circle(5));

        for(TwoDShape shape : shapes){
            System.out.println(shape);
            System.out.println(shape.getArea());
        }
    }
}

public class DrawingCanvas {

    public static void printArea(Shape s) {
        System.out.println("Area: " + s.calculateArea());
    }

    public static void main(String[] args) {

        CircleShape c =
                new CircleShape(5.0);

        SquareShape sq =
                new SquareShape(4.0);

        System.out.println(
                "Circle Area: "
                + c.calculateArea()
        );

        System.out.println(
                "Square Area: "
                + sq.calculateArea()
        );

        sq.scale(2.0);

        System.out.println(
                "Scaled Square Area: "
                + sq.calculateArea()
        );

        printArea(c);

        System.out.println(
                "Circle ID: "
                + c.getShapeId()
        );

        System.out.println(
                "Square ID: "
                + sq.getShapeId()
        );
    }
}

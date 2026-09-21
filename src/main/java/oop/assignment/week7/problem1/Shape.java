public abstract class Shape {

    private static int counter = 0;
    private final String shapeId;

    public Shape() {
        counter++;
        shapeId = "SH-" + counter;
    }

    public abstract double calculateArea();

    public void scale(double factor) {
    }

    public void scale(double xFactor, double yFactor) {
        scale(xFactor);
        scale(yFactor);
    }

    public String getShapeId() {
        return shapeId;
    }
}

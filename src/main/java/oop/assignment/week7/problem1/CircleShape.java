public class CircleShape extends Shape {

    private double radius;

    public CircleShape(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void scale(double factor) {
        radius = radius * factor;
    }
}

package analyticalgeometry;

public class Line {
    Point point;
    double angle;

    public Line(Point point, double angle) {
        this.point = point;
        this.angle = angle;
    }

    double getSlope() {
        return 1/Math.tan(angle);
    }

    double getYIntercept() {
        return point.getY() - getSlope() * point.getX();
    }
}
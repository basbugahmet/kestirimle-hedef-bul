package analyticalgeometry;

import java.io.Serializable;
public class Point implements Serializable { // Serializable is used to send Point in socket
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.valueOf(x) + ":" + String.valueOf(y);
    }
}

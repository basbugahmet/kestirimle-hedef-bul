package analyticalgeometry;

import exceptions.SensorPositionException;

public class IntersectionFinder {

    // Returns the intersection point of two lines
    public Point findIntersection(Line line1, Line line2) throws SensorPositionException {
        double m1 = line1.getSlope();
        double b1 = line1.getYIntercept();
        double m2 = line2.getSlope();
        double b2 = line2.getYIntercept();

        // If sensors are top of each other
        if (m1 == m2) {
            throw new SensorPositionException("Sensors on top of each other!");
        }

        double x = (b2 - b1) / (m1 - m2);
        // if the slope of first line is infinite, use properties of second line
        double y = (m1 > -Math.pow(Math.exp(1), 10) && m1 < Math.pow(Math.exp(1), 10)) ? m1 * x + b1 : m2 * x + b2;

        x = Math.round(x * 100.0) / 100.0;
        y = Math.round(y * 100.0) / 100.0;

        return new Point(x, y);
    }
}

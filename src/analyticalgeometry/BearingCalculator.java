package analyticalgeometry;

import components.Target;

public class BearingCalculator {
    // This function calculates the bearing according to trigonometrical rules
    public double calculateBearing(Point sensorPoint, Target target) {
        double slope = (target.getTargetLocation().getX() - sensorPoint.getX()) / (target.getTargetLocation().getY() - sensorPoint.getY());
        double angleInRadians = Math.atan(slope); // arctan()
        double angleInDegrees = Math.toDegrees(angleInRadians); // convert to degree from radian

        // If target above the sensor
        if (target.getTargetLocation().getY() > sensorPoint.getY()){
            if (-90 <= angleInDegrees && angleInDegrees <= 0) {
                angleInDegrees += 360;
            }
        // If target below the sensor
        } else if(target.getTargetLocation().getY() < sensorPoint.getY()) {
                angleInDegrees += 180;
        // If target is left to the sensor
        } else if(target.getTargetLocation().getX() < sensorPoint.getX()) {
                angleInDegrees += 360;
        }

        return angleInDegrees;
    }
}

package components;

import analyticalgeometry.Point;

public class Sensor {
    private final String sensorName;
    private final Point sensorLocation;

    public Sensor(String sensorName, Point point) {
        this.sensorName = sensorName;
        this.sensorLocation = point;
    }

    public String getSensorName() {
        return sensorName;
    }


    public Point getSensorLocation() {
        return sensorLocation;
    }


}

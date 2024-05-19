package components;

import analyticalgeometry.IntersectionFinder;
import analyticalgeometry.Line;
import analyticalgeometry.Point;
import exceptions.SensorPositionException;

import java.util.ArrayList;

public class Processor {

    public Point process(ArrayList<String> data) throws SensorPositionException {
        IntersectionFinder intersectionFinder = new IntersectionFinder();

        // Parsing the received data sent by sensor application
        String[] firstSensorData = data.get(0).split(":");
        String[] secondSensorData = data.get(1).split(":");

        double firstSensorX = Double.parseDouble(firstSensorData[0]);
        double firstSensorY = Double.parseDouble(firstSensorData[1]);
        double firstBearing = Double.parseDouble(firstSensorData[2]);

        double secondSensorX = Double.parseDouble(secondSensorData[0]);
        double secondSensorY = Double.parseDouble(secondSensorData[1]);
        double secondBearing = Double.parseDouble(secondSensorData[2]);

        // Creating the lines
        Line firstLine = new Line(new Point(firstSensorX,firstSensorY), Math.toRadians(firstBearing));
        Line secondLine = new Line(new Point(secondSensorX,secondSensorY), Math.toRadians(secondBearing));

        return intersectionFinder.findIntersection(firstLine,secondLine);

    }


}

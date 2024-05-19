package applications;
import analyticalgeometry.BearingCalculator;
import analyticalgeometry.Point;
import analyticalgeometry.RandomPointGenerator;
import communication.DataSender;
import communication.SensorDataReceiver;
import components.Sensor;
import components.Target;
import exceptions.SensorPositionException;

import java.util.Objects;


public class SensorApplication {

    public static void main(String[] args) throws SensorPositionException {
        // Creating socket on port 12345
        SensorDataReceiver dataReceiver = new SensorDataReceiver(12345);
        Target target = (Target) dataReceiver.receiveData();

        System.out.println("Received Data from Target Application: x:" + target.getTargetLocation().getX() + " y:"
                + target.getTargetLocation().getY());

        // Creating two sensors with randomized coordinates
        RandomPointGenerator rpg = new RandomPointGenerator();
        Sensor firstSensor = new Sensor("1.Sensor", rpg.randomPointGenerator());
        Sensor secondSensor = new Sensor("2.Sensor",  rpg.randomPointGenerator());

        // Throw a customized exception if the first sensor is on top of the target
        if (Objects.equals(target.getTargetLocation().toString(), firstSensor.getSensorLocation().toString())) {
            throw new SensorPositionException(String.format(
                    "The first sensor is located directly on top of the target! Sensor location: x:%.2f, y:%.2f",
                    firstSensor.getSensorLocation().getX(),
                    firstSensor.getSensorLocation().getY()
            ));
        }

        // Throw a customized exception if the second sensor is on top of the target
        if (Objects.equals(target.getTargetLocation().toString(), secondSensor.getSensorLocation().toString())) {
            throw new SensorPositionException(String.format(
                    "The second sensor is located directly on top of the target! Sensor location: x:%.2f, y:%.2f",
                    secondSensor.getSensorLocation().getX(),
                    secondSensor.getSensorLocation().getY()
            ));
        }

        // Calculate the bearing for each sensor
        BearingCalculator bearingCalculator = new BearingCalculator();
        double firstBearing = bearingCalculator.calculateBearing(firstSensor.getSensorLocation(), target);
        double secondBearing = bearingCalculator.calculateBearing(secondSensor.getSensorLocation(), target);

        System.out.println("Sensor 1 Location : x:" + firstSensor.getSensorLocation().getX() + " y:" +
                firstSensor.getSensorLocation().getY() + " Bearing: " + firstBearing);
        System.out.println("Sensor 2 Location : x:" + secondSensor.getSensorLocation().getX() + " y:" +
                secondSensor.getSensorLocation().getY() + " Bearing: " + secondBearing) ;

        // Send data to the processor application on port 12346
        DataSender dataSender = new DataSender("localhost", 12346);
        dataSender.sendData(firstSensor.getSensorLocation().toString() + ":" +  firstBearing);
        dataSender.sendData(secondSensor.getSensorLocation().toString() + ":" + secondBearing);

    }


}

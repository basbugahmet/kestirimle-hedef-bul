package applications;

import analyticalgeometry.Point;
import communication.ProcessorDataReceiver;
import components.Processor;
import exceptions.SensorPositionException;

import java.util.ArrayList;

public class ProcessorApplication {

    public static void main(String[] args) throws SensorPositionException {

        Processor processor = new Processor();
        // Creating socket on port 12346
        ProcessorDataReceiver dataReceiver = new ProcessorDataReceiver(12346);
        ArrayList<String> dataList = (ArrayList<String>) dataReceiver.receiveData();
        // Calling the finding target function through processor object
        Point targetCoordinates = processor.process(dataList);
        System.out.println("Detected Target Location: x: " + targetCoordinates.getX() + " y: " +  targetCoordinates.getY());

    }
}

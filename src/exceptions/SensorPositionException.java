package exceptions;

public class SensorPositionException extends Exception { // Customized exception class for sensor positions
    public SensorPositionException(String message) {
        super(message);
    }
}

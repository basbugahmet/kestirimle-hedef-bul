package communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DataSender {

    private final String host;
    private final int portNumber;

    public DataSender(String host, int portNumber) {
        this.host = host;
        this.portNumber = portNumber;
    }

    public void sendData(Object data) {
        try (Socket socket = new Socket(host, portNumber);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
            out.writeObject(data);
        } catch (IOException e) {
            System.err.println("Connection could not be established on port: " + portNumber);
        }
    }

    public String getHost() {
        return host;
    }

    public int getPortNumber() {
        return portNumber;
    }



}

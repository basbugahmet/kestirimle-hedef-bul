package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SensorDataReceiver extends DataReceiver {

    public SensorDataReceiver(int portNumber) {
        super(portNumber);
    }

    @Override
    public Object receiveData() {
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Sensor application is waiting for client(s) on port " + portNumber);
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {
                    System.out.println("Client connected: " + clientSocket.getInetAddress());
                    Object data = in.readObject();
                    return data;
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

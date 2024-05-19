package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ProcessorDataReceiver extends DataReceiver{
    public ProcessorDataReceiver(int portNumber) {
        super(portNumber);
    }

    @Override
    public Object receiveData() {
        ArrayList<String> dataList = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Processor application is waiting for client(s) on port " + portNumber);
            while (dataList.size() < 2) { // waits until the data of two sensors is received
                try (Socket clientSocket = serverSocket.accept();
                     ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {
                    System.out.println("Client connected: " + clientSocket.getInetAddress());
                    Object data = in.readObject();
                    dataList.add((String) data);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}

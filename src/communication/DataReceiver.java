package communication;

public abstract class DataReceiver {
    final int portNumber;

    public DataReceiver(int portNumber) {
        this.portNumber = portNumber;
    }

    public abstract Object receiveData();

    public int getPortNumber() {
        return portNumber;
    }
}


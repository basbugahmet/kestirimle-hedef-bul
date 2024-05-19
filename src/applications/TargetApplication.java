package applications;

import analyticalgeometry.RandomPointGenerator;
import communication.DataSender;
import components.Target;

public class TargetApplication {

    public static void main(String[] args) {
        // Creating target with randomized coordinates
        RandomPointGenerator rpg = new RandomPointGenerator();
        Target target = new Target(rpg.randomPointGenerator());
        System.out.println("Target Location: x:" + target.getTargetLocation().getX() + " y:" + target.getTargetLocation().getY());

        // Send data to the processor application on port 12346
        DataSender dataSender = new DataSender("localhost",12345);
        dataSender.sendData(target);
    }

}

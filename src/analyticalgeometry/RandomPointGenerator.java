package analyticalgeometry;

import java.util.Random;

public class RandomPointGenerator {

    public Point randomPointGenerator() {
        int FIELD_SIZE = 1000;
        Random random = new Random();

        double x = random.nextDouble() * (FIELD_SIZE + 1) - (double) FIELD_SIZE / 2;
        double y = random.nextDouble() * (FIELD_SIZE + 1) - (double) FIELD_SIZE / 2;

        x = Math.round(x * 100.0) / 100.0;
        y = Math.round(y * 100.0) / 100.0;

        return new Point(x, y);
    }


}

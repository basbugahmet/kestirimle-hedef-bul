package components;

import analyticalgeometry.Point;

import java.io.Serializable;
public class Target implements Serializable {  // Serializable is used to send Target in socket

    private Point targetLocation;

    public Target(Point targetLocation) {
        this.targetLocation = targetLocation;
    }

    public Point getTargetLocation() {
        return targetLocation;
    }
}

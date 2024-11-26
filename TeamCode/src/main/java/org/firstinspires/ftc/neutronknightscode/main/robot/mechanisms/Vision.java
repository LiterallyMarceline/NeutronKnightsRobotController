package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;

import android.graphics.Point;

import org.firstinspires.ftc.neutronknightscode.main.field.Field;

public class Vision {

    public Point calculateLocation() {
        if(!Field.checkInbounds(new Point(0,0))) throw new Error("Out of Bounds"); else return new Point(0,0);
    }
    public RobotPlacements getPlacement() {
        return RobotPlacements.RED_LEFT;
    }

}

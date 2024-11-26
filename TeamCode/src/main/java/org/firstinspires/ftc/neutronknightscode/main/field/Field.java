package org.firstinspires.ftc.neutronknightscode.main.field;

import android.graphics.Point;

public class Field {

    public static final Point startingPoint = new Point(0,0);
    public static final Point endingPoint = new Point(10,10);

    public static boolean checkInbounds(Point position){
        boolean outOfBoundsX = position.x < startingPoint.x || endingPoint.x < position.x;
        boolean outOfBoundsY = position.y < startingPoint.y || endingPoint.y < position.y;
        return !outOfBoundsX && !outOfBoundsY;
    }
}
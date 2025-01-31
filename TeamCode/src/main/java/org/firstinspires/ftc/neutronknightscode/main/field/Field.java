package org.firstinspires.ftc.neutronknightscode.main.field;

import android.graphics.Point;

public class Field {

    public static final Point startingPoint = new Point(0,0);
    public static final Point endingPoint = new Point(10,10);
    public int max_x = 338;
    public int max_y = 338;

//    public int submersible_x = 117;
//    public int submersible_y = 117;
//    142;
//
//    217;
//    242;
//
//    123;
//    113;
//
//    30 by 8;


    public static boolean checkInbounds(Point position){
        boolean outOfBoundsX = position.x < startingPoint.x || endingPoint.x < position.x;
        boolean outOfBoundsY = position.y < startingPoint.y || endingPoint.y < position.y;
        return !outOfBoundsX && !outOfBoundsY;
    }
}
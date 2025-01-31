
package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;

import android.graphics.Point;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms.Drivetrain;
import org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms.Robot;

@Autonomous
public class RobotAutoNothing extends RobotOpMode {

    private boolean ran = false;
    public void loop() {
//        this does nothing
        if(!ran){
            //robot.drivetrain.diagonalStrafe(new Point(5,5),0.5f,telemetry);
            //robot.drivetrain.diagonalStrafe(new Point(-5,5),0.5f,telemetry);
            robot.drivetrain.diagonalStrafe(new Point(5,-5),0.5f,telemetry);
            //robot.drivetrain.diagonalStrafe(new Point(-5,-5),0.5f,telemetry);
            ran = true;



        }
        robot.drivetrain.updateOdo(telemetry);
    }

}

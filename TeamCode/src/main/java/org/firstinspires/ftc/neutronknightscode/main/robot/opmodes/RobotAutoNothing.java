
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

            ran = true;



        }
        robot.drivetrain.updateOdo(telemetry);
    }

}

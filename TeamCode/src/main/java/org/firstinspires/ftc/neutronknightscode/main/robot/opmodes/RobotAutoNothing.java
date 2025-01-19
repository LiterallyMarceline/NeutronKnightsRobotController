
package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms.Robot;

@Autonomous
public class RobotAutoNothing extends RobotOpMode {

    private boolean ran = false;
    public void loop() {
        //this does nothing
        if(!ran){
            robot.move(5000,0.25f,telemetry);
            ran = true;
        }
        robot.drivetrain.updateOdo(telemetry);
    }

}

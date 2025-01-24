
package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms.Robot;

@Autonomous
public class RobotAutoNothing extends RobotOpMode {

    private boolean ran = false;
    public void loop() {
//        this does nothing
        if(!ran){
            ran = true;
            robot.move(-200, .25f, 5, telemetry);
            robot.drivetrain.strafe(700, .25f, 3, telemetry);

            robot.move(600, .25f, 5, telemetry);


            robot.drivetrain.strafe(200, .25f, 3, telemetry);
            robot.move(-1000, .25f, 5, telemetry);
            robot.move(1000, .25f, 5, telemetry);

            robot.drivetrain.strafe(200, .25f, 3, telemetry);
            robot.move(-1000, .25f, 5, telemetry);
            robot.move(1000, .25f, 5, telemetry);

            robot.drivetrain.strafe(200, .25f, 3, telemetry);
            robot.move(-1100, .25f, 5, telemetry);

        }
        robot.drivetrain.updateOdo(telemetry);
    }

}

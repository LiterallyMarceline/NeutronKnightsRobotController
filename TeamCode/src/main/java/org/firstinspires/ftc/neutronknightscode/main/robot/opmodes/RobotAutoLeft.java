package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms.Robot;

@Autonomous
public class RobotAutoLeft extends RobotOpMode {

    private boolean ran = false;

    int forward = 25;
    public void loop() {
        int i = 1;

        if(!ran) {
            // hang the specimen
            robot.hangSpecimen(Robot.Heights.HIGH, telemetry);

            robot.move(forward, .25f, telemetry);
            robot.strafe(9);
            robot.move(1100, .25f, telemetry);
            robot.drivetrain.turn(-85,.25, telemetry);
            robot.move(70, .25f, telemetry);
            robot.arm.setPosition(robot.armPositionBar);


            // start procedure to move samples into observation zone
//            robot.strafe(40);
//            robot.arm.setPosition(robot.armPositionBar);
//            robot.move(25, .5f);
//            robot.strafe(5);
//
//            while (i <= 3) {
//                robot.move(-50, .5f);
//
//                if (i != 3) {
//                    robot.move(50, .5f);
//                    robot.strafe(5);
//                }
//
//                i+=1;
//            }

            ran = true;
        }
        robot.drivetrain.updateOdo(telemetry);
    }
}
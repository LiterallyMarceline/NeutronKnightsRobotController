package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms.Robot;

@Autonomous
public class RobotAutoRight extends RobotOpMode {

    private boolean ran = false;


    public void loop() {
        int i = 1;

        if(!ran) {
            // hang the specimen
            robot.hangSpecimen(Robot.Heights.HIGH, telemetry);

            // start procedure to move samples into observation zone
//            robot.strafe(35);
//            robot.arm.setPosition(robot.armPositionBar);
//            robot.move(25, .5f);
//            robot.strafe(5);

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


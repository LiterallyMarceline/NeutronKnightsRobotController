package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms.Robot;

@Autonomous
public class RobotAutoRight extends RobotOpMode {

    private boolean ran = false;

    int forward = 20;
    public void loop() {
        int i = 1;

        if(!ran) {
            // hang the specimen
            int forwardDistance = 500;

            int reverse = -20;
            int reverseDistance = -400;


            robot.move(forwardDistance, .25f,10, telemetry);
            robot.drivetrain.turn(15, 0.25, telemetry);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            robot.hangSpecimen(Robot.Heights.HIGH, telemetry);

            robot.move(forward, .25f,10, telemetry);

            robot.drivetrain.strafe(-1600, .5f,10, telemetry);
            robot.move(-50,.25f,10, telemetry);


           // robot.drivetrain.turn(-80, .5, telemetry);
            robot.arm.setPosition(robot.armPositionWall);

            robot.intake.intake(.5);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            robot.intake.intake(0);

            robot.strafe(1600, 0.25f, 10, telemetry );
            robot.move(200, .25f,10, telemetry);
            robot.hangSpecimen(Robot.Heights.HIGH, telemetry);

            //To move samples into zone
            //robot.move(-200, .25f, telemetry);
            //robot.drivetrain.odoStrafe(800);

            //repeat this twice more
            //robot.move(200, .25f, telemetry);
            //robot.drivetrain.odoStrafe(-100);
            //robot.move(-200, .25f, telemetry);


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
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
            int forwardDistance = 420;

            int reverse = -20;
            int reverseDistance = -400;

            try {
                // move forward and turn towards submersible
                robot.move(forwardDistance, .25f, 5, telemetry);
                robot.drivetrain.turn(20, 0.25, telemetry);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                // hang specimen over bar
                robot.hangSpecimen(Robot.Heights.HIGH, telemetry);

                // clear back wall
                robot.move(forward, .25f, 1, telemetry);

                // pick up one specimen
                grabAndHang();
                //samplePickUp();
                robot.arm.setPosition(0);
                goToCorner();






                // start procedure to move samples into observation zone
//            robot.strafe(40);
////            robot.arm.setPosition(robot.armPositionBar);
////            robot.move(25, .5f);
////            robot.strafe(5);
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
            catch (Exception e) {
            }
            finally {
                // clean up robot by resetting arm and drivetrain motor settings
                robot.reset();
            }
        }
        robot.drivetrain.updateOdo(telemetry);
    }

    public void grabAndHang()
    {
        // move towards side wall and slow down towards the end
        robot.drivetrain.strafe(-900, 1f, 3, telemetry);
        robot.drivetrain.strafe(-500, .5f, 2, telemetry);

        // move forward in case we are against the wall
        robot.move(20, .5f, 2, telemetry);

        // raise arm to obtain specimen
        robot.arm.setPosition(robot.armPositionWall-35);

        // position in corner
        robot.drivetrain.strafe(-50, .5f, 1, telemetry);
        robot.move(-20, .5f, 1, telemetry);
        robot.move(-250, .25f, 2, telemetry);

        // grab specimen
        robot.intake.intake(.5);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // take specimen off the wall
        robot.arm.setPosition(robot.armPositionWall + 500);
        robot.move(15, .25f, 5, telemetry);

        robot.intake.intake(0);

        // raise arm
        robot.arm.setPosition(robot.armPositionBar);

        // start towards the submersible
        robot.move(100, .25f, 2, telemetry);
        robot.strafe(1300, 0.5f, 5, telemetry);

        // square against the back wall
        //robot.drivetrain.turn(-5, 0.25, telemetry); // if not straight add back in

        robot.underHangSpecimen(Robot.Heights.HIGH, telemetry);
    }

    public void goToCorner()
    {
        // move towards side wall and slow down towards the end
        robot.drivetrain.strafe(-1500, 1f, 5, telemetry);
        robot.drivetrain.strafe(-500, .5f, 2, telemetry);

        // verify you are in the corner
        //robot.move(-200, .25f,2, telemetry);
        //robot.drivetrain.strafe(-1000, .25f, 2, telemetry);
       // robot.move(-400, .25f,2, telemetry);
    }
    public void samplePickUp()
        {
            robot.move(-200, .25f, 5, telemetry);
            robot.drivetrain.strafe(-1000, .25f, 5, telemetry);

            robot.move(700, .25f, 5, telemetry);


            robot.drivetrain.strafe(-200, .25f, 3, telemetry);
            robot.move(-1000, .25f, 5, telemetry);
            robot.move(1000, .25f, 5, telemetry);

            robot.drivetrain.strafe(-200, .25f, 3, telemetry);
            robot.move(-1000, .25f, 5, telemetry);
            robot.move(1000, .25f, 5, telemetry);

            robot.drivetrain.strafe(-200, .25f, 3, telemetry);
            robot.move(-1100, .25f, 5, telemetry);
    }
}
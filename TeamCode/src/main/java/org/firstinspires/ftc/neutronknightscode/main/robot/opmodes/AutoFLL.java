
package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class AutoFLL extends RobotOpMode {

    private boolean ran = false;
    public void loop() {
//        this does nothing
        if(!ran){

            ran = true;
//            robot.drivetrain.move(100, .5f, 5, telemetry);
//            robot.drivetrain.strafe(200,.5f,5, telemetry);
//            robot.drivetrain.turn(50,.5f,telemetry);
//            robot.arm.setPosition(robot.armPositionBar);
//            robot.intake.intake(0.5);

//            robot.drivetrain.move(200,.5f, 5, telemetry);
//            robot.drivetrain.strafe(200, 0.5f, 5, telemetry);
//            robot.drivetrain.turn(50, .5f, telemetry);
//            robot.arm.setPosition(robot.armPositionBar);
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            robot.intake.eject(0.75f);

//            robot.drivetrain.move(200, 0.5f, 5,telemetry);
//            robot.drivetrain.strafe(200,0.5f,5, telemetry);
//            robot.drivetrain.turn(90,0.5f, telemetry);
//            robot.arm.setPosition(robot.armPositionBar);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            //robot.intake.eject(.5f);

            robot.drivetrain.move(200, 0.5f, 5, telemetry);
            robot.drivetrain.strafe(200,0.5f, 5, telemetry);
            robot.drivetrain.turn(57, 0.5, telemetry);

            robot.arm.setPosition(robot.armPositionBar);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            robot.intake.eject(.5f);

        }
        robot.drivetrain.updateOdo(telemetry);
    }

}

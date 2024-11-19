package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class RobotTeleOp extends RobotOpMode {

    private boolean setInverted = false;
    private boolean inverted = false;

    @Override
    public void loop() {

        double positivePower = gamepad1.right_stick_y - gamepad1.right_stick_x;
        double negativePower = gamepad1.right_stick_y + gamepad1.right_stick_x;

        double leftPower = gamepad1.right_trigger - gamepad1.left_trigger;
        double rightPower = gamepad1.left_trigger - gamepad1.right_trigger;

        double topLeftPower = positivePower + rightPower;
        double bottomRightPower = positivePower + leftPower;
        double topRightPower = negativePower + leftPower;
        double bottomLeftPower = negativePower + rightPower;

        if(gamepad1.right_bumper){
            topLeftPower /= 2;
            bottomRightPower /= 2;
            topRightPower /= 2;
            bottomLeftPower /= 2;
        }

        if(gamepad1.a && !setInverted){
            setInverted = true;
            inverted = !inverted;
        } else {
            setInverted = gamepad1.a;
        }

        if(inverted){
            topLeftPower = -topLeftPower;
            bottomRightPower = -bottomRightPower;
            topRightPower = -topRightPower;
            bottomLeftPower = -bottomLeftPower;
        }

        robot.drivetrain.setPower(
                -topLeftPower,
                bottomRightPower,
                topRightPower,
                -bottomLeftPower
        );

    }
}
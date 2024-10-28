package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;

import static org.firstinspires.ftc.neutronknightscode.main.robot.Robot.servo;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class ServoTeleOp extends RobotTeleOp {
    @Override
    public void loop(){
        super.loop();
        long x = 250;
        double w = 1;
        double y = 0;
        double z = 180;

        if (gamepad1.right_bumper) {


            servo.setPower(1);

            try {
                Thread.sleep(x);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (gamepad1.left_bumper) {


            servo.setPower(-1);

            try {
                Thread.sleep(x);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        double Power = gamepad1.left_stick_y;
    }
}

package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp
public class RobotTeleOp extends RobotOpMode {

    private final Gamepad currentGamepad1 = new Gamepad();
    private final Gamepad previousGamepad1 = new Gamepad();
    private final Gamepad currentGamepad2 = new Gamepad();
    private final Gamepad previousGamepad2 = new Gamepad();

    @Override
    public void loop() {

        previousGamepad1.copy(currentGamepad1);
        previousGamepad2.copy(currentGamepad2);

        currentGamepad1.copy(gamepad1);
        currentGamepad2.copy(gamepad2);

        telemetry.addData("power", "%f power", currentGamepad2.right_stick_y * 180);
        telemetry.update();

        if (currentGamepad1.a && !previousGamepad1.a) {
            robot.toggleInvert();
        }
        if(currentGamepad1.right_bumper && !previousGamepad1.right_bumper) {
            robot.toggleSlow();
        }
        if(currentGamepad2.left_bumper && !previousGamepad2.left_bumper){
            robot.toggleSlowIntake();
        }
        if (currentGamepad2.right_bumper && !previousGamepad2.right_bumper) {
            robot.toggleDirection();
        }
        try {
            robot.giveInputs(gamepad1,gamepad2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
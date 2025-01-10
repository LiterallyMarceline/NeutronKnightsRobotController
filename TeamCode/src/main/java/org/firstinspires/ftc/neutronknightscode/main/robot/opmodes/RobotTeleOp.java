package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms.Arm;

@TeleOp
public class RobotTeleOp extends RobotOpMode {

    private final Gamepad currentGamepad1 = new Gamepad();
    private final Gamepad previousGamepad1 = new Gamepad();
    private final Gamepad currentGamepad2 = new Gamepad();
    private final Gamepad previousGamepad2 = new Gamepad();

    private final int down = 4694;
    private final int bar = 2900;
    private final int basket = 2725;

    @Override
    public void loop() {

        previousGamepad1.copy(currentGamepad1);
        previousGamepad2.copy(currentGamepad2);

        currentGamepad1.copy(gamepad1);
        currentGamepad2.copy(gamepad2);

        telemetry.addData("power", "%f power", -gamepad2.right_stick_y);
        telemetry.update();

       // telemetry.addData("position", "%f pos", Arm.pivotPosition);
        // telemetry.update();


        if (currentGamepad1.a && !previousGamepad1.a) {
            robot.toggleInvert1();
        }
        if (currentGamepad1.b && !previousGamepad1.b) {
            robot.toggleInvert2();
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
            robot.giveInputs(gamepad1,gamepad2, telemetry);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //arm set position

        if (gamepad2.dpad_down) {
        robot.arm.setPosition(down);
        }
        if (gamepad2.dpad_up) {
            robot.arm.setPosition(basket);
        }
        if (gamepad2.dpad_right) {
            robot.arm.setPosition(bar);
        }

    }
}
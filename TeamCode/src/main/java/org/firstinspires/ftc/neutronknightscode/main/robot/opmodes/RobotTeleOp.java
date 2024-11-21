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

        if(currentGamepad1.a && !previousGamepad1.a){
            robot.toggleInvert();
        }
        if(currentGamepad1.right_bumper && !previousGamepad1.right_bumper){
            robot.toggleSlow();
        }

        robot.giveInputs(gamepad1,gamepad2);

    }
}
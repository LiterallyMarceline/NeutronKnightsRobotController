package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;

import static org.firstinspires.ftc.neutronknightscode.main.robot.Robot.drivetrain;
import static org.firstinspires.ftc.neutronknightscode.main.robot.Robot.spinningBrushIntake;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms.inputs.gamepad.ButtonPressedEventHandler;
import org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms.inputs.gamepad.buttonPressedEvent.ButtonPressedEventSource;
import org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms.inputs.gamepad.gamepadPresets.GamepadPresets;

@TeleOp
public class RobotTeleOp extends RobotOpMode {
    private ButtonPressedEventSource gamepad;
    private GamepadPresets preset;
    private ButtonPressedEventHandler handler;
    @Override
    public void init() {
        super.init();
        gamepad = new ButtonPressedEventSource();
        preset = GamepadPresets.DEFAULT;
        handler = new ButtonPressedEventHandler(preset.getPreset());
        gamepad.addButtonPressedEventListener(handler);
    }
    @Override
    public void loop() {
        gamepad.checkButtonsPressed(gamepad1);
        double positivePower = gamepad1.right_stick_y-gamepad1.right_stick_x;
        double negativePower = gamepad1.right_stick_y+gamepad1.right_stick_x;
        telemetry.addData("Gamepad Buttons Pressed", "Shows buttons pressed.");
        telemetry.addLine(String.format("Slow Button: %b, Turning Mode Button: %b", handler.slow, handler.turningMode));
        telemetry.update();
        if(handler.slow){
            positivePower = positivePower/2;
            negativePower = negativePower/2;
        }
        drivetrain.setPower(
                positivePower,
                -positivePower,
                -negativePower,
                negativePower
        );
        if (gamepad1.left_bumper) {
            spinningBrushIntake.setPower(1);
        }
        if (gamepad1.right_bumper) {
            spinningBrushIntake.setPower(-1);
        }
        if (gamepad1.a) {
            spinningBrushIntake.setPower(0);
        }
        handler.slow = false;
        handler.turningMode = false;
    }
}

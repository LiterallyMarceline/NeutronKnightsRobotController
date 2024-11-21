package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot implements Mechanism{

    public Drivetrain drivetrain;
    public Arm arm;
    public Intake intake;

    public boolean inverted = false;
    public boolean slow = false;

    public Robot(){
        drivetrain = new Drivetrain();
        arm = new Arm();
        intake = new Intake();
    }
    @Override
    public void init(HardwareMap hardwareMap){
        drivetrain.init(hardwareMap);
        // arm.init(hardwareMap);
        // intake.init(hardwareMap);
    }
    public void toggleInvert(){
        inverted = !inverted;
    }
    public void toggleSlow(){
        slow = !slow;
    }
    public void giveInputs(Gamepad gamepad1, Gamepad gamepad2){
        double positivePower = gamepad1.right_stick_y - gamepad1.right_stick_x;
        double negativePower = gamepad1.right_stick_y + gamepad1.right_stick_x;

        double leftPower = gamepad1.right_trigger - gamepad1.left_trigger;
        double rightPower = gamepad1.left_trigger - gamepad1.right_trigger;

        double topLeftPower = positivePower + rightPower;
        double bottomRightPower = positivePower + leftPower;
        double topRightPower = negativePower + leftPower;
        double bottomLeftPower = negativePower + rightPower;

        if(slow){
            topLeftPower /= 2;
            bottomRightPower /= 2;
            topRightPower /= 2;
            bottomLeftPower /= 2;
        }

        if(inverted){
            topLeftPower = -topLeftPower;
            bottomRightPower = -bottomRightPower;
            topRightPower = -topRightPower;
            bottomLeftPower = -bottomLeftPower;
        }

        drivetrain.setPower(
                -topLeftPower,
                bottomRightPower,
                topRightPower,
                -bottomLeftPower
        );
    }
    public enum Heights {
        HIGH,
        LOW
    }
    public void hangSpecimen(Heights bar){
        switch(bar){
            case HIGH:
                break;
            case LOW:
                break;
        }
    }
    public void scoreBasket(Heights basket){
        switch(basket){
            case HIGH:
                break;
            case LOW:
                break;
        }
    }
    public void getSpecimen(){

    }
    public void getSample(){

    }
}

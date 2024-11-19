package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot implements Mechanism{

    public Drivetrain drivetrain;
    public Arm arm;
    public Intake intake;

    public Robot(){
        drivetrain = new Drivetrain();
        arm = new Arm();
        intake = new Intake();
    }
    @Override
    public void init(HardwareMap hardwareMap){
        drivetrain.init(hardwareMap);
        arm.init(hardwareMap);
        intake.init(hardwareMap);
    }
    public void giveInputs(Gamepad gamepad1, Gamepad gamepad2){

    }
    public enum Bars {
        HIGH_BAR,
        LOW_BAR
    }
    public void hangSpecimen(Bars bar){
        switch(bar){
            case HIGH_BAR:
                break;
            case LOW_BAR:
                break;
        }
    }
    public void highBasket(){

    }
    public void lowBasket(){

    }
    public void getSpecimen(){

    }
    public void getSample(){

    }
}

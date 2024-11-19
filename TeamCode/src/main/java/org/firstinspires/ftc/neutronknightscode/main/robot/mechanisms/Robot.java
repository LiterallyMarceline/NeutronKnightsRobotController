package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot implements Mechanism{

    public Drivetrain drivetrain;
    public Arm arm;
    public Intake intake;

    private Robot(){
        drivetrain = new Drivetrain();
        arm = new Arm();
        intake = new Intake();
    }

    public void init(HardwareMap hardwareMap){
        drivetrain.init(hardwareMap);
        arm.init(hardwareMap);
        intake.init(hardwareMap);
    }
}

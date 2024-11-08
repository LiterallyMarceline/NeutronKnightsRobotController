package org.firstinspires.ftc.neutronknightscode.main.robot;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms.Drivetrain;
import org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms.Servo;

public class Robot {

    public static Drivetrain drivetrain;
    //public static Servo servo;

    private Robot(){
        drivetrain = new Drivetrain();
    }

    public static Robot init(HardwareMap hardwareMap){
        Robot robot = new Robot();
        drivetrain.init(hardwareMap);
        //servo.init(hardwareMap);
        return robot;
    }
}

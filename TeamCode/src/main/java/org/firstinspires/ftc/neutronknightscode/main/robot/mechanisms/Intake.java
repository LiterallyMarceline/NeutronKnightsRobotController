 package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake implements Mechanism {

    //public volatile int speed = 0;
    private CRServo intakeServo1;
    private CRServo intakeServo2;

    @Override
    public void init(HardwareMap hardwareMap) {
        intakeServo1 = hardwareMap.get(CRServo.class, "intakeServo1");
        intakeServo2 = hardwareMap.get(CRServo.class, "intakeServo2");

    }
    public void turnOff(){
        intakeServo1.setPower(0);
        intakeServo2.setPower(0);
    }
    public void intake(double power){
        intakeServo1.setPower(power);
        intakeServo2.setPower(-power);

    }
    public void eject(double power) {
        intakeServo1.setPower(-power);
        intakeServo2.setPower(power);

    }
    }

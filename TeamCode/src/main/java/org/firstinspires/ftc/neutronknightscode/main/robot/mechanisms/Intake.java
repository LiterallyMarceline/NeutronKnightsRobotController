 package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake implements Mechanism {

    //public volatile int speed = 0;
    private CRServo intakeServoLeft;
    private CRServo intakeServoRight;

    @Override
    public void init(HardwareMap hardwareMap) {
        try {
            intakeServoLeft = hardwareMap.get(CRServo.class, "intakeServoLeft");
            intakeServoRight = hardwareMap.get(CRServo.class, "intakeServoRight");
        } catch (Exception e){
            return;
        }
        intakeServoRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void setPower(double power){
        intakeServoLeft.setPower(power);
        intakeServoRight.setPower(power);
    }
    public void turnOff(){
        intakeServoLeft.setPower(0);
        intakeServoRight.setPower(0);
    }
    public void intake(double power){
        intakeServoLeft.setPower(-power);
        intakeServoRight.setPower(-power);
    }
    public void eject(double power) {
        intakeServoLeft.setPower(power);
        intakeServoRight.setPower(power);

    }
}

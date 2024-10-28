package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class Servo implements Mechanism {

    private CRServo Servo;

    @Override
    public void init(HardwareMap hardwareMap) {
        Servo = hardwareMap.get(CRServo.class, "Servo");
    }

    public void setPower(int servoPower){
        Servo.setPower(servoPower);
    }

}
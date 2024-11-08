package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class DoubleWheelSpinningIntake implements Mechanism{

    private CRServo Servo;
    private CRServo Servo2;

    @Override
    public void init(HardwareMap hardwareMap) {

        Servo = hardwareMap.get(CRServo.class, "Servo");
        Servo2 = hardwareMap.get(CRServo.class, "Servo2");

        double x = 1;
        double y = 1;
    }

    public void setPower(int Power) {

        Servo2.setPower(Power);
        Servo.setPower(-Power);

    }
}


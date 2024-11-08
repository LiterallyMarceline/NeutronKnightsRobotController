package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms.Intake;


@TeleOp
public class TestingTeleOp extends OpMode{

    private CRServo IntakeServo;
    private CRServo IntakeServo2;
    private CRServo BaseServo;
    private CRServo PivotServo;
    /*private DcMotor WonkyServo; */

    public void init() {
        /* WonkyServo = hardwareMap.get(DcMotor.class, "WonkyServo"); */

        IntakeServo = hardwareMap.get(CRServo.class, "IntakeServo4");
        IntakeServo2 = hardwareMap.get(CRServo.class, "IntakeServo5");
        BaseServo = hardwareMap.get(CRServo.class, "BaseServo2");
        PivotServo = hardwareMap.get(CRServo.class, "PivotServo3");

    }

    @Override
    public void loop() {
        /* 6 Revolutions!!! */

        double Power = gamepad2.left_stick_y;

        /* if (gamepad1.b) {
            double x = (double) 180 /312;

            WonkyServo.setPower(-x);

            try {
                Thread.sleep(5500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            WonkyServo.setPower(0);
        }
        if (gamepad1.a) {
            double x = (double) 180 /312;

            WonkyServo.setPower(x);

            try {
                Thread.sleep(5500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            WonkyServo.setPower(0);
        }
        */

        IntakeServo.setPower(-Power);
        IntakeServo2.setPower(Power);

        BaseServo.setPower(gamepad2.right_trigger);
        PivotServo.setPower(gamepad2.left_trigger);






    }

}
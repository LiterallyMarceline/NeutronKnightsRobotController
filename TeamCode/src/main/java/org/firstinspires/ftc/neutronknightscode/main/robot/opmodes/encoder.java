package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.DcMotor;

@TeleOp(name = "Encoder")
import com.qualcomm.robotcore.hardware.DcMotor;

public class encoder extends OpMode{
    DcMotor motor;
    double ticks = 2786.2;
    double newTarget;
    @Override

    public void init() {
        motor = hardwareMap.get(DcMotor.class,  "motor");
        telemetry.addData("Hardware: ", "Initialized");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
    @Override
    public void loop() {
        if(gamepad1.a)
        {
            encoder(2);

        }
        telemetry.addData("Motor Ticks", motor.getCurrentPosition());
    }
    public void encoder(int turnage){
        newTarget = ticks/turnage;
        motor.setTargetPosition((int)newTarget);
        motor.setPower(0.3);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void tracker(){
        motor.setTargetPosition(0);
        motor.setPower(0.8);
        motor.setMode(DcMotor.RunMode);
    }
}

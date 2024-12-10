package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;

import android.graphics.Point;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain implements Mechanism{

    private DcMotor topLeft;
    private DcMotor bottomRight;
    private DcMotor topRight;
    private DcMotor bottomLeft;

    private volatile Point position;

    private volatile float heading;
    private volatile float pitch;

    private double maxSpeed;

    public Drivetrain(){}

    @Override
    public void init(HardwareMap hardwareMap) {
        try {
            topLeft = hardwareMap.get(DcMotor.class, "topLeft");
            bottomRight = hardwareMap.get(DcMotor.class, "bottomRight");
            topRight = hardwareMap.get(DcMotor.class, "topRight");
            bottomLeft = hardwareMap.get(DcMotor.class, "bottomLeft");
        } catch (Exception e){
            return;
        }
        topLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        bottomLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void setPower(double topLeftPower, double bottomRightPower, double topRightPower, double bottomLeftPower){
        topLeft.setPower(topLeftPower);
        bottomRight.setPower(bottomRightPower);
        topRight.setPower(topRightPower);
        bottomLeft.setPower(bottomLeftPower);
    }
    public void move(double distance){

    }
    public void strafe(double distance){

    }
    public void turn(float radians){

    }
    public void goTo(int x, int y, float orientation){

    }
}

package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain implements Mechanism{

    private DcMotor topLeft;
    private DcMotor bottomRight;
    private DcMotor topRight;
    private DcMotor bottomLeft;

    private int x;
    private int y;

    private float yaw;
    private float pitch;

    private double maxSpeed;

    public Drivetrain(){}

    @Override
    public void init(HardwareMap hardwareMap) {
        topLeft = hardwareMap.get(DcMotor.class, "topLeft");
        bottomRight = hardwareMap.get(DcMotor.class, "bottomRight");
        topRight = hardwareMap.get(DcMotor.class, "topRight");
        bottomLeft = hardwareMap.get(DcMotor.class, "bottomLeft");
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
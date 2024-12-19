package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;

import android.graphics.Point;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain implements Mechanism{

    private DcMotor topLeft;
    private DcMotor bottomRight;
    private DcMotor topRight;
    private DcMotor bottomLeft;

    private volatile Point position;
    private final MotorEncoder drivetrainEncoder = new MotorEncoder(538, 1);

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

        topLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bottomRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        topRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bottomLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        drivetrainEncoder.drivetrainEncoder(1.04);
    }
    public void setPower(double topLeftPower, double bottomRightPower, double topRightPower, double bottomLeftPower) {
        topLeft.setPower(topLeftPower);
        bottomRight.setPower(bottomRightPower);
        topRight.setPower(topRightPower);
        bottomLeft.setPower(bottomLeftPower);
    }
    private void startEncoder(){
        topLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        topLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bottomRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        topRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bottomLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void runToPosition(int topLeftTarget, int bottomRightTarget, int topRightTarget, int bottomLeftTarget){
        topLeft.setTargetPosition(topLeftTarget);
        bottomRight.setTargetPosition(bottomRightTarget);
        topRight.setTargetPosition(topRightTarget);
        bottomLeft.setTargetPosition(bottomLeftTarget);

        topLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bottomRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        topRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bottomLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        double topLeftPower = topLeftTarget == 0 ? 0 : topLeftTarget > topLeft.getCurrentPosition() ? 1 : -1;
        double bottomRightPower = bottomRightTarget == 0 ? 0 : bottomRightTarget > bottomRight.getCurrentPosition() ? 1 : -1;
        double topRightPower = topRightTarget == 0 ? 0 : topRightTarget > topRight.getCurrentPosition() ? 1 : -1;
        double bottomLeftPower = bottomLeftTarget == 0 ? 0 : bottomLeftTarget > bottomLeft.getCurrentPosition() ? 1 : -1;

        setPower(topLeftPower, bottomRightPower, topRightPower, bottomLeftPower);

        while (topLeft.isBusy() && bottomRight.isBusy() && topRight.isBusy() && bottomLeft.isBusy()){
            int topLeftPos = topLeft.getCurrentPosition();
            int bottomRightPos = bottomRight.getCurrentPosition();
            int topRigthPos = topRight.getCurrentPosition();
            int bottomLeftPos = bottomLeft.getCurrentPosition();
        }

        setPower(0,0,0,0);

        topLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bottomRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        topRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bottomLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void move(double distance){
        startEncoder();

        int topLeftTarget = topLeft.getCurrentPosition() + (int)(distance * drivetrainEncoder.ticksPerCm);
        int bottomRightTarget = bottomRight.getCurrentPosition() + (int)(distance * drivetrainEncoder.ticksPerCm);
        int topRightTarget = topRight.getCurrentPosition() + (int)(distance * drivetrainEncoder.ticksPerCm);
        int bottomLeftTarget = bottomLeft.getCurrentPosition() + (int)(distance * drivetrainEncoder.ticksPerCm);

        runToPosition(topLeftTarget,bottomRightTarget,topRightTarget,bottomLeftTarget);
    }
    public void strafe(double distance){
        startEncoder();

        int topLeftTarget = topLeft.getCurrentPosition() + (int)(distance * drivetrainEncoder.ticksPerCm);
        int bottomRightTarget = bottomRight.getCurrentPosition() + (int)(distance * drivetrainEncoder.ticksPerCm);
        int topRightTarget = topRight.getCurrentPosition() - (int)(distance * drivetrainEncoder.ticksPerCm);
        int bottomLeftTarget = bottomLeft.getCurrentPosition() - (int)(distance * drivetrainEncoder.ticksPerCm);

        runToPosition(topLeftTarget,bottomRightTarget,topRightTarget,bottomLeftTarget);
    }
    public void turn(int degrees){

    }
    public void goTo(int x, int y, float orientation){

    }
}

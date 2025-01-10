package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;

import android.graphics.Point;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.neutronknightscode.main.robot.lib.GoBildaPinpointDriver;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

import java.util.Locale;

public class Drivetrain implements Mechanism{

    private GoBildaPinpointDriver odo;
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

        topLeft = hardwareMap.get(DcMotor.class, "topLeft");
        bottomRight = hardwareMap.get(DcMotor.class, "bottomRight");
        topRight = hardwareMap.get(DcMotor.class, "topRight");
        bottomLeft = hardwareMap.get(DcMotor.class, "bottomLeft");

        odo = hardwareMap.get(GoBildaPinpointDriver.class, "odo");
        odo.setOffsets(125.0, 100.0);
        odo.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        odo.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD, GoBildaPinpointDriver.EncoderDirection.REVERSED);
        odo.resetPosAndIMU();

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
            int topRightPos = topRight.getCurrentPosition();
            int bottomLeftPos = bottomLeft.getCurrentPosition();
        }

        setPower(0,0,0,0);

        topLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bottomRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        topRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bottomLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    //    public void move(double x, float power){
//        odo.update();
//        double targetX = odo.getPosX() + x;
//        inlineFunc heading = (radians) -> {return (int) (radians * (180/Math.PI));};
//        int odoHeading = heading.run(odo.getHeading());
//        int orgHeading = odoHeading;
//        double motorPower = x == 0 ? 0 : targetX > odo.getPosY() ? -1 * power : 1 * power;
//        setPower(motorPower,motorPower,motorPower,motorPower);
//        while(true){
//            odo.update();
//            if(x < 0){
//                if(targetX >= odo.getPosX()) break;
//            } else {
//                if(targetX <= odo.getPosX()) break;
//            }
//        }
//        setPower(0,0,0,0);
//        int target = odoHeading - orgHeading;
//        turn(target, telemetry);
//    }
    // for debugging
    public void move(double x, float power, Telemetry telemetry){
        odo.update();
        double targetX = odo.getPosX() + x;
        inlineFunc heading = (radians) -> {return (int) (radians * (180/Math.PI));};
        int odoHeading = heading.run(odo.getHeading());
        int orgHeading = odoHeading;
        double motorPower = x == 0 ? 0 : targetX > odo.getPosX() ? -1 * power : 1 * power;
        setPower(motorPower,motorPower,motorPower,motorPower);
        while(true){
            odo.update();
            updateOdo(telemetry);
            if(x < 0){
                if(targetX >= odo.getPosX()) break;
            } else {
                if(targetX <= odo.getPosX()) break;
            }
        }
        setPower(0,0,0,0);
        int target = odoHeading - orgHeading;
        turn(target, power, telemetry);
    }
    //    public void move(double distance){
//        startEncoder();
//
//        int topLeftTarget = topLeft.getCurrentPosition() + (int)(distance * drivetrainEncoder.ticksPerCm);
//        int bottomRightTarget = bottomRight.getCurrentPosition() + (int)(distance * drivetrainEncoder.ticksPerCm);
//        int topRightTarget = topRight.getCurrentPosition() + (int)(distance * drivetrainEncoder.ticksPerCm);
//        int bottomLeftTarget = bottomLeft.getCurrentPosition() + (int)(distance * drivetrainEncoder.ticksPerCm);
//
//        runToPosition(topLeftTarget,bottomRightTarget,topRightTarget,bottomLeftTarget);
//    }
    public void strafe(double distance){
        startEncoder();

        int topLeftTarget = topLeft.getCurrentPosition() + (int)(distance * drivetrainEncoder.ticksPerCm);
        int bottomRightTarget = bottomRight.getCurrentPosition() + (int)(distance * drivetrainEncoder.ticksPerCm);
        int topRightTarget = topRight.getCurrentPosition() - (int)(distance * drivetrainEncoder.ticksPerCm);
        int bottomLeftTarget = bottomLeft.getCurrentPosition() - (int)(distance * drivetrainEncoder.ticksPerCm);

        runToPosition(topLeftTarget,bottomRightTarget,topRightTarget,bottomLeftTarget);
    }
    interface inlineFunc {
        int run(double doubl);
    }
    public void turn(int degrees, double power, Telemetry telemetry){
        odo.update();
        inlineFunc heading = (radians) -> (int) (radians * (180/Math.PI));
        int odoHeading = heading.run(odo.getHeading());
        double targetHeading = odoHeading + degrees;

        double leftMotorPower = degrees == 0 ? 0 : targetHeading > odoHeading ? -1* power: 1* power;
        double rightMotorPower = degrees == 0 ? 0 : targetHeading > odoHeading ? 1 * power: -1 * power;
        setPower(leftMotorPower, rightMotorPower, rightMotorPower, leftMotorPower);
        if(degrees != 0){
            while (true) {
                odo.update();
                updateOdo(telemetry);
                odoHeading = heading.run(odo.getHeading());
                if (degrees < 0) {
                    if (targetHeading >= odoHeading) break;
                } else {
                    if (targetHeading <= odoHeading) break;
                }
            }
        }
        setPower(0,0,0,0);
    }
    public void goTo(int x, int y, float orientation){

    }
    public void updateOdo(Telemetry telemetry){
        odo.update();
        telemetry.addData("Status", "Initialized");
        telemetry.addData("X offset", odo.getXOffset());
        telemetry.addData("Y offset", odo.getYOffset());
        telemetry.addData("Device Version Number:", odo.getDeviceVersion());
        telemetry.addData("Device Scalar", odo.getYawScalar());
        Pose2D pos = odo.getPosition();
        String data = String.format(Locale.US, "{X: %.3f, Y: %.3f, H: %.3f}", pos.getX(DistanceUnit.MM), pos.getY(DistanceUnit.MM), pos.getHeading(AngleUnit.DEGREES));
        telemetry.addData("Position", data);
        Pose2D vel = odo.getVelocity();
        String velocity = String.format(Locale.US,"{XVel: %.3f, YVel: %.3f, HVel: %.3f}", vel.getX(DistanceUnit.MM), vel.getY(DistanceUnit.MM), vel.getHeading(AngleUnit.DEGREES));
        telemetry.addData("Velocity", velocity);
        telemetry.addData("Status", odo.getDeviceStatus());
        telemetry.addData("Pinpoint Frequency", odo.getFrequency()); //prints/gets the current refresh rate of the Pinpoint
        telemetry.update();
        telemetry.update();
    }
}
/*odo.update();

 */
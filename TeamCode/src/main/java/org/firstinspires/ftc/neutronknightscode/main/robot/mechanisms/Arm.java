package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

// All the code above is imports
public class Arm implements Mechanism {
    // Creating the motors and servos objects.
    // private Servo BaseServo; @Deprecated
    private DcMotor pivotMotor;
    private DcMotor slideMotor;
    private MotorEncoder pivotEncoder;
    private MotorEncoder slideEncoder;


    // Important Variables!
    public volatile double pivotPosition;
    public volatile double slidePosition;

    private int positionToKeep = 0;

    @Deprecated
    public volatile double basePosition;

    @Override
    public void init(HardwareMap hardwareMap) {
        // Configuring motors and servos.
        // BaseServo = hardwareMap.get(Servo.class, "BaseServo2"); @Deprecated
        try {
            pivotMotor = hardwareMap.get(DcMotor.class, "pivotMotor");
            //slideMotor = hardwareMap.get(DcMotor.class, "slideMotor");
        } catch (Exception e){
            return;
        }
        pivotEncoder = new MotorEncoder(1425.1,25/6);
        slideEncoder = new MotorEncoder(1425.1,1);

        // Creating a brake for the pivoting motor so that it will not have to be bounced.
        pivotMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Setting position variables to 0 for starting position.
        // basePosition = 0; @Deprecated
        pivotPosition = 0;
        slidePosition = 0;

        pivotMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        pivotMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        pivotMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    /**
     * TeleOp Method
     * @param pivotPower the power for the pivotMotor
     * @see #init(HardwareMap)
     */
    public void setPower(double pivotPower, Telemetry telemetry/*, double slidePower (Not in use yet)*/){
        // pivotPosition = pivotMotor.getCurrentPosition(); Not in use yet;
        // slidePosition = slideMotor.getCurrentPosition(); Not in use yet

        // Not in use yet;
        /*
        double pivotMax;
        double pivotMin;
         */
        double slideMax;
        double slideMin;

        // testing set to position
        if(pivotPower < 0)
        {
            pivotMotor.setTargetPosition(pivotMotor.getCurrentPosition()-200);
            positionToKeep = pivotMotor.getCurrentPosition();
            pivotMotor.setPower(pivotPower);
        } else if(pivotPower > 0){
            pivotMotor.setTargetPosition(pivotMotor.getCurrentPosition()+200);
            positionToKeep = pivotMotor.getCurrentPosition();
            pivotMotor.setPower(pivotPower);
        } else
        {
            pivotMotor.setTargetPosition(positionToKeep);
            pivotMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            //pivotMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            pivotMotor.setPower(.2);
        }

        telemetry.addData("arm power", "%f power", pivotPower);
        telemetry.addData("arm pos", "%d pos", pivotMotor.getCurrentPosition());
        telemetry.update();
        // Not in use yet
        /*if(pivotMin <= pivotPosition && pivotPosition <= pivotMax)*/


        /*if(slideMin <= slidePosition && slidePosition <= slideMax) slideMotor.setPower(slidePower);*/
    }
    // UNFINISHED
    public void pivot(double amount) {
        pivotMotor.setPower(amount);
    }
    @Deprecated
    public void slide(long rotations) throws InterruptedException {
        // Get the amount IN ROTATIONS: as a double

        if (slidePosition >= 0) {
            if (slidePosition <= 1) {
                slideMotor.setPower(rotations/Math.abs(rotations));
                Thread.sleep(512 * rotations);
                slideMotor.setPower(0);
                slidePosition += rotations/7;
            }
            // TO BE FIXED LATER.. GET RID OF TIME AND USE DISTANCE
        }
    }
    @Deprecated
    public void rotate(double amount) {
        // Get the amount IN DEGREES: as a double
        double gearboxRatio = 1;

        if ((amount / 180) + basePosition < 180) {
            if ((amount / 180) + basePosition > 0) {
                basePosition += amount / 180;
                //BaseServo.setPosition(basePosition);
            }
        }
    }
}

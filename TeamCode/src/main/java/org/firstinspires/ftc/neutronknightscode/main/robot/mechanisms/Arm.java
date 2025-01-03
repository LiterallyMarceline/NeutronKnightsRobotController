package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

// All the code above is imports
public class Arm implements Mechanism {
    // Creating the motors and servos objects.
    // private Servo BaseServo; @Deprecated
    private DcMotor pivotMotor;
    private DcMotor slideMotor;
    private CRServo rotationServo;
    private MotorEncoder pivotEncoder;
    private MotorEncoder slideEncoder;

    private boolean autoSetPosition = false;

    // Important Variables!
    public static volatile double pivotPosition;
    public volatile double slidePosition;
    public volatile double rotationPosition;

    private int positionToKeep = 0;

    @Override
    public void init(HardwareMap hardwareMap) {
        // Configuring motors and servos.
        // BaseServo = hardwareMap.get(Servo.class, "BaseServo2"); @Deprecated
        try {
            pivotMotor = hardwareMap.get(DcMotor.class, "pivotMotor");
            //slideMotor = hardwareMap.get(DcMotor.class, "slideMotor");

            rotationServo = hardwareMap.get(CRServo.class,"rotationServo");
        } catch (Exception e){
            return;
        }
        // Configuring the encoders for future encoding.. I guess..
        pivotEncoder = new MotorEncoder(1425.1,25/6);
        slideEncoder = new MotorEncoder(1425.1,1);
        // Creating a brake for the pivoting motor so that it will not have to be bounced.
        pivotMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Setting position variables to 0 for starting position.
        pivotPosition = 0;
        slidePosition = 0;
        rotationPosition = 0;

        // Setting the mode for the encoders.
        pivotMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        pivotMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        pivotMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    /**
     * TeleOp Method
     * @param hardwareMap the power for the pivotMotor
     * @see #init(HardwareMap)
     */

    public void loop(HardwareMap hardwareMap) {
        pivotPosition = pivotMotor.getCurrentPosition();
    }
    public void setPower(double pivotPower, Telemetry telemetry/*, double slidePower (Not in use yet)*/){
        // pivotPosition = pivotMotor.getCurrentPosition(); Not in use yet;
        // slidePosition = slideMotor.getCurrentPosition(); Not in use yet
        pivotMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
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
            autoSetPosition = false;
            pivotMotor.setTargetPosition(pivotMotor.getCurrentPosition()-200);
            positionToKeep = pivotMotor.getCurrentPosition();
            pivotMotor.setPower(pivotPower);
        } else if(pivotPower > 0){
            autoSetPosition = false;
            pivotMotor.setTargetPosition(pivotMotor.getCurrentPosition()+200);
            positionToKeep = pivotMotor.getCurrentPosition();
            pivotMotor.setPower(pivotPower);
        } else
        {
            if(!autoSetPosition)
            {
                pivotMotor.setTargetPosition(positionToKeep);
                pivotMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                //pivotMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                pivotMotor.setPower(.2);
            }

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

    public void rotate(double amount) {
        // Get the amount IN POWER: as a double
        rotationServo.setPower(amount);
    }
    public void setPosition(int pos)
    {
        autoSetPosition = true;
        pivotMotor.setTargetPosition(pos);

        pivotMotor.setPower(1);


    }
}
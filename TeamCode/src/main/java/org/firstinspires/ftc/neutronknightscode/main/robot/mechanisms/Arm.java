package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

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

    @Deprecated
    public volatile double basePosition;

    @Override
    public void init(HardwareMap hardwareMap) {
        // Configuring motors and servos.
        // BaseServo = hardwareMap.get(Servo.class, "BaseServo2"); @Deprecated
        pivotMotor = hardwareMap.get(DcMotor.class, "PivotMotor0");
        slideMotor = hardwareMap.get(DcMotor.class, "WonkyServo");

        pivotEncoder = new MotorEncoder(1425.1,25/6);
        slideEncoder = new MotorEncoder(1425.1,1);

        // Creating a brake for the pivoting motor so that it will not have to be bounced.
        pivotMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Setting position variables to 0 for starting position.
        // basePosition = 0; @Deprecated
        pivotPosition = 0;
        slidePosition = 0;
    }

    /**
     * TeleOp Method
     * @param pivotPower the power for the pivotMotor
     * @param slidePower the power for the slideMotor
     * @see #init(HardwareMap)
     */
    public void setPower(double pivotPower, double slidePower){
        // pivotPosition = pivotMotor.getCurrentPosition(); Not in use yet;
        slidePosition = slideMotor.getCurrentPosition();

        // Not in use yet;
        /*
        double pivotMax;
        double pivotMin;
         */
        double slideMax;
        double slideMin;

        // Not in use yet
        /*if(pivotMin <= pivotPosition && pivotPosition <= pivotMax)*/ pivotMotor.setPower(pivotPower);
        /*if(slideMin <= slidePosition && slidePosition <= slideMax)*/ slideMotor.setPower(slidePower);
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

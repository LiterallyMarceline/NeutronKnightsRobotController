package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;


import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

// All the code above is imports
public class Arm implements Mechanism{
    // Creating the motors and servos objects.
    private Servo BaseServo;
    private DcMotor PivotMotor;
    private DcMotor WonkyServo;


    // Important Variables!
    public volatile double pivotPosition;
    public volatile double slidePosition;
    public volatile double basePosition;

    @Override
    public void init(HardwareMap hardwareMap) {
        // Configuring motors and servos.
        BaseServo = hardwareMap.get(Servo.class, "BaseServo2");
        PivotMotor = hardwareMap.get(DcMotor.class, "PivotMotor");

        WonkyServo = hardwareMap.get(DcMotor.class, "WonkyServo");

        // Creating a brake for the pivoting motor so that it will not have to be bounced.
        PivotMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Setting position variables to 0 for starting position.
        basePosition = 0;
        pivotPosition = 0;
        slidePosition = 0;
    }


    public boolean rotate(int amount) {
        // Get the amount IN DEGREES: as a double
        double gearboxRatio = 1;
        boolean statement = false;

        if ((amount / 180) + basePosition < 180) {
            if ((amount / 180) + basePosition > 0) {
                basePosition += amount / 180;
                BaseServo.setPosition(basePosition);
                statement = true;
            }
        }

        return statement;
    }

    public boolean pivot(int amount, boolean direction) throws InterruptedException {
        // Get the amount IN DEGREES: as a double
        double gearboxRatio = 10/3;
        boolean statement = false;
        int direction_multiply = direction ? -1:1;

        if (amount+pivotPosition < 181) {
            if (amount+pivotPosition > 0) {
                PivotMotor.setPower(0.256410256 * direction_multiply);
                Thread.sleep((amount / 180) * 1000L);
                PivotMotor.setPower(0);
                statement = true;
            }
        }

        return statement;
    }
    public void slide(long rotations, boolean directionboolean) throws InterruptedException {
        // Get the amount IN ROTATIONS: as a double
        int direction;

        direction = directionboolean ? 1 : -1;

        if (slidePosition>=0) {
            if (slidePosition <= 1) {
                WonkyServo.setPower(direction);
                Thread.sleep(512 * rotations);
                WonkyServo.setPower(0);
                if (directionboolean) {
                    slidePosition += rotations / 7;
                } else {
                    slidePosition -= rotations / 7;
                }
            }
        }


    }


}
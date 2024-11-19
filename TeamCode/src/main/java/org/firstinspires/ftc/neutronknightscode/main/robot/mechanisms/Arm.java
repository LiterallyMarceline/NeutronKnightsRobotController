package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;


import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

// All the code above is
public class Arm implements Mechanism{
    private Servo BaseServo;
    private Servo PivotServo;
    private DcMotor WonkyServo;

    private volatile int pivotPosition;
    private volatile int rotation;
    private volatile int extensionPosition;

    @Override
    public void init(HardwareMap hardwareMap) {
        BaseServo = hardwareMap.get(Servo.class, "BaseServo2");
        PivotServo = hardwareMap.get(Servo.class, "PivotServo3");

        WonkyServo = hardwareMap.get(DcMotor.class, "WonkyServo");

    }

    public void rotate(int degrees) {
        // Get the amount IN DEGREES: as a double
        double position = degrees / 180;
        BaseServo.setPosition(position);
    }
    public void pivot(int degrees) {
        // Get the amount IN DEGREES: as a double
        double gearRatio = (2/3) * 5;
        pivotPosition += degrees*gearRatio;
        PivotServo.setPosition(PivotServo.getPosition() + degrees);

    }
    public void slide(long distance) throws InterruptedException {

        WonkyServo.setPower(180/312);

        long value = 5500*distance;

        Thread.sleep(value);

    }

    }

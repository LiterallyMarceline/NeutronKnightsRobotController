package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot implements Mechanism{

    public Drivetrain drivetrain;
    public Arm arm;
    public Intake intake;

    public boolean inverted1 = false;
    public boolean inverted2 = false;
    public boolean slow = false;
    public boolean ejectSlow = false;
    public boolean direction = true;

    //update these bottom values
    //then test going back
    public final int armPositionDown = 5138;
    public final int armPositionBar = 3336;
    public final int armPositionBasket = 3160;

    public Robot(){
        drivetrain = new Drivetrain();
        arm = new Arm();
        intake = new Intake();
    }
    @Override
    public void init(HardwareMap hardwareMap){
        drivetrain.init(hardwareMap);
        arm.init(hardwareMap);
        intake.init(hardwareMap);
    }
    public void toggleInvert1(){
        inverted1 = !inverted1;
    }
    public void toggleInvert2(){

        inverted2 = !inverted2;
    }
    public void toggleSlow(){
        slow = !slow;
    }
    public void toggleDirection(){
        direction = !direction;
    }
    public void toggleSlowIntake() { ejectSlow = !ejectSlow; }

    public void giveInputs(Gamepad gamepad1, Gamepad gamepad2, Telemetry telemetry) throws InterruptedException {

        double right_stick_x = 3* gamepad1.right_stick_x;
        double right_stick_y = 3* gamepad1.right_stick_y;
        double right_trigger = 3* gamepad1.right_trigger;
        double left_trigger = 3* gamepad1.left_trigger;

        right_stick_x = Math.pow(3, 3*right_stick_x-2);
        right_stick_y = Math.pow(3, 3*right_stick_y-2);
        right_trigger = Math.pow(3, 3*right_trigger-2);
        left_trigger = Math.pow(3, 3*left_trigger-2);

        right_stick_x = right_stick_x/3;
        right_stick_y = right_stick_y/3;
        right_trigger = right_trigger/3;
        left_trigger = left_trigger/3;

        right_trigger = left_trigger/2;
        left_trigger = right_trigger/2;

        if(inverted1){
            right_stick_x = -right_stick_x;
            right_stick_y = -right_stick_y;
        }

        if(inverted2){
            right_trigger = -right_trigger;
            left_trigger = -left_trigger;
        }



        double positivePower = gamepad1.right_stick_y - gamepad1.right_stick_x;
        double negativePower = gamepad1.right_stick_y + gamepad1.right_stick_x;

        double leftPower = gamepad1.left_trigger - gamepad1.right_trigger;
        double rightPower = gamepad1.right_trigger - gamepad1.left_trigger;

        double topLeftPower = positivePower + rightPower;
        double bottomRightPower = positivePower + leftPower;
        double topRightPower = negativePower + leftPower;
        double bottomLeftPower = negativePower + rightPower;

        if(slow){
            topLeftPower /= 2;
            bottomRightPower /= 2;
            topRightPower /= 2;
            bottomLeftPower /= 2;
        }

        drivetrain.setPower(
                topLeftPower,
                bottomRightPower,
                topRightPower,
                bottomLeftPower
        );

        double ejectPower = ejectSlow ? gamepad2.left_trigger/2 : gamepad2.left_trigger;
        double intakePower = gamepad2.right_trigger;

        double totalIntakePower = ejectPower-intakePower;
        intake.setPower(totalIntakePower);

        arm.setPower(-gamepad2.right_stick_y, telemetry );
        //arm.pivot(direction ? (long) gamepad2.right_trigger : (long) -gamepad2.right_trigger);

        arm.rotate(gamepad2.left_stick_x);

        //arm.slide((long) gamepad2.left_stick_y*360);
    }
    public enum Heights {
        HIGH,
        LOW
    }
    public void hangSpecimen(Heights bar, Telemetry telemetry){
        switch(bar){
            case HIGH:
                int forwardDistance = 500;

                int reverse = -20;
                int reverseDistance = -450;

                move(forwardDistance, .25f, telemetry);
                drivetrain.turn(15, 0.25, telemetry);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                arm.setPosition(armPositionBar);
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                intake.intake(1);
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


                intake.intake(0.25);
                arm.setPosition(armPositionBar+50);
                intake.intake(0);
                move(reverseDistance, .25f, telemetry);
                intake.intake(0.25);
                arm.setPosition(-(armPositionDown+50));
                try {
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                intake.intake(0);
                //drivetrain.turn(10, 0.25, telemetry);

                //move(reverse, .25f, telemetry);

        }
    }
//    public void move(int distance, float power){
//        drivetrain.move(distance, power);
//    }
    public void move(int distance, float power, Telemetry telemetry){
        drivetrain.move(distance, power, telemetry);
    }
    public void strafe(double distance){
        drivetrain.strafe(distance);
    }
    public void scoreBasket(Heights basket){
        switch(basket){
            case HIGH:
                break;
            case LOW:
                break;
        }
    }
    public void getSpecimen(){

    }
    public void getSample(){

    }
}
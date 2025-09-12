package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;

public class RobotCamera {

}
@TeleOp(name = "Camera Test", group = "Exampleses-Parth")
public class CameraTestOpMode extends LinearOpMode{

    private VisionPortal visionPortal;

    @Override
    public void runOpMode() {
        //Get the webcam from the hardware map
        WebcamName webcamName = hardwareMap.get(WebcamName.class, "Webcam 1");

        //Build the VisionPortal
        visionPortal = new VisionPortal.Builder() {
            .setCamera(webcam)
            .build;

        telemetry.addLine("Camera initiated, waiting for startttttttt!!")
        telemetry.update();

        waitForStart();
        }
    }

}

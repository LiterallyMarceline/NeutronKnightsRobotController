package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms.Robot;


public abstract class RobotOpMode extends OpMode {

    public Robot robot = new Robot();

    @Override
    public void init() {
        robot.init(hardwareMap);
    }
}

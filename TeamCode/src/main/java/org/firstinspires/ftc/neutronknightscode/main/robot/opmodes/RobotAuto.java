package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms.Robot;

@Autonomous
public class RobotAuto extends RobotOpMode {

    private boolean ran = false;

    public void loop() {
        if(!ran) {
            // hang the specimen
            robot.hangSpecimen(Robot.Heights.HIGH);
            ran = true;
        }
    }
}


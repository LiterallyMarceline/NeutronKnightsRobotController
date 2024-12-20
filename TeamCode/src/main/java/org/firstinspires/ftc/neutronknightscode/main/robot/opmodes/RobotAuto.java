package org.firstinspires.ftc.neutronknightscode.main.robot.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class RobotAuto extends RobotOpMode {


    private boolean ran = false;
    @Override
    public void loop() {
        if(!ran) {
            robot.move(500);
            ran = true;
        }
    }
}


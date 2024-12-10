package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.neutronknightscode.main.robot.opmodes.RobotOpMode;

public interface Mechanism {
    /**
     * Initializes Hardware Devices using the hardwareMap from the OpMode
     * @param hardwareMap the hardwareMap from the OpMode that is running the method
     * @see RobotOpMode#init()
     */
    public void init(HardwareMap hardwareMap);
}

package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;

public class MotorEncoder {
     public int ticksPerRev;
     public float gearRatio;
     public double wheelDiameter;
     public double ticksPerCm;

    /**
     * MotorEncoder Constructor
     * @param tpr sets {@link #ticksPerRev}
     * @param gr sets {@link #gearRatio} multiplier
     */
     public MotorEncoder(double tpr, float gr){
         ticksPerRev = (int) Math.floor(tpr);
         gearRatio = gr;
     }

    /**
     * Allows for Encoder to be used for Drivetrain
     * @param wd sets {@link #wheelDiameter} in cm
     * @param tpcm sets {@link #ticksPerCm}
     * @return returns the Encoder
     */
     public MotorEncoder drivetrainEncoder(double wd, double tpcm){
         wheelDiameter = wd;
         ticksPerCm = tpcm;
         return this;
     }

    /**
     * Gets the ticks per full rotation of the last gear connected to the motor
     * @return returns the tick # as a double
     */
    public double getTicksPerGearRotation(){
        return ticksPerRev*gearRatio;
     }
}

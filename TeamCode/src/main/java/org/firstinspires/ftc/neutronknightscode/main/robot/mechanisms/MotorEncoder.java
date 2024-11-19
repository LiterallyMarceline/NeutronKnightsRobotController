package org.firstinspires.ftc.neutronknightscode.main.robot.mechanisms;

public class MotorEncoder {
     public double ticksPerRev;
     public float gearRatio;
     public double wheelDiameter;
     public double ticksPerCm;

     public MotorEncoder(double tpr, float gr, double wd, double tpcm){
         ticksPerRev = tpr;
         gearRatio = gr;
         wheelDiameter = wd;
         ticksPerCm = tpcm;
     }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.VictorSP;

public class Collector extends SubsystemBase {
  private final VictorSP ballcollecter_motor = new VictorSP(19);
  /** Creates a new Collector. */


  public Collector() {}

  // When called, sets speed of collector motor
  
  public void setSpeed(double speed){
    ballcollecter_motor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Shooter extends SubsystemBase {
  private final WPI_VictorSPX shooter_motor = new WPI_VictorSPX(Constants.utilMotors.m_shooter);
  /** Creates a new Shooter. */
  public Shooter() {

  }
  public void set(double speed){
    shooter_motor.set(speed);
  }

  @Override
  public void periodic() {  

  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Climber extends SubsystemBase {
  private final WPI_VictorSPX climberMotor = new WPI_VictorSPX(Constants.driveMotors.m_climber);
  /** Creates a new Climber. */
  public Climber() {}

  public void goUpwards(){
    climberMotor.set(1);
  }

  public void goDownwards(){
    climberMotor.set(-1);
  }

  public void setSpeed(double speed){
    climberMotor.set(speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

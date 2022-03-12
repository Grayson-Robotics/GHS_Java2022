// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class DriveTrain extends SubsystemBase {

  // Declares all SpeedControllers needed to run every motor. 
private static final WPI_VictorSPX m_topLeft = new WPI_VictorSPX(Constants.driveMotors.m_topLeft);
private static final WPI_VictorSPX m_bottomLeft = new WPI_VictorSPX(Constants.driveMotors.m_bottomLeft);

private static final WPI_VictorSPX m_topRight = new WPI_VictorSPX(Constants.driveMotors.m_topRight);
private static final WPI_VictorSPX m_bottomRight = new WPI_VictorSPX(Constants.driveMotors.m_bottomRight);

private static final MotorControllerGroup m_leftMotorGroup = new MotorControllerGroup(m_topLeft, m_bottomLeft);
private static final MotorControllerGroup m_rightMotorGroup = new MotorControllerGroup(m_topRight, m_bottomRight);

 private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMotorGroup, m_rightMotorGroup);

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    m_rightMotorGroup.setInverted(true);
    m_robotDrive.setDeadband(0.1);
  }
  
  public void drive(double xSpeed, double zRotation){
    m_robotDrive.arcadeDrive(xSpeed, zRotation);
  }

  public double getPWMValueOfLeftGroup(){
    return m_leftMotorGroup.get();
  }

  public double getPWMValueOfRightGroup(){
    return m_rightMotorGroup.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

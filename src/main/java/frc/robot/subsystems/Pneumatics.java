// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.Constants;

public class Pneumatics extends SubsystemBase {
  
  //Declare the solenoids for use in our subsystem.
  private static final DoubleSolenoid solenoid1 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.solenoids.solenoid1, Constants.solenoids.solenoid2);

  /** Creates a new Pneumatics. */
  public Pneumatics() {
    solenoid1.set(Value.kReverse);
  }

  public void toggleSolenoid(){
    solenoid1.toggle();
  }

  public void setForward(){
    solenoid1.set(Value.kForward);
  }

  public void setReverse(){
    solenoid1.set(Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SolenoidBase;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;


public class DoubleSoleniod extends SubsystemBase {
  /** Creates a new pneumatics. */

  
  public DoubleSoleniod() {
    // Solinoid ports need to be added
   /* DoubleSolenoid Solenoid1 = new DoubleSolenoid(1,2);
    DoubleSolenoid Solenoid2 = new DoubleSolenoid(4,5);

Solenoid1.set(kOff);
Solenoid1.set(kForward);
Solenoid1.set(kReverse);

Solenoid2.set(kOff);
Solenoid2.set(kForward);
Solenoid2.set(kReverse);*/


   // xbox not defined 
/*if(xbox.getBButtonPressed()){
   Solenoid1.Toggle();}

if(xbox.getBButtonPressed()){ 
  Solenoid2.Toggle();} */

}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

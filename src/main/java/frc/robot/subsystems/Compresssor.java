// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;

public class Compresssor extends SubsystemBase {
  /** Creates a new Compresssor. */
  public Compresssor() {
Compressor c = new Compressor(0);

//starts compressor
boolean enabled = c.enabled();
boolean pressureSwitch =c.getPressureSwitchValue();
double current = c.getCompressorCurrent();
boolean compressor_status;

c.setClosedLoopControl(true);
c.start();
compressor_status = c.getPressureSwitchValue();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

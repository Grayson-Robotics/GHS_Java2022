// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subclasses;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Button;

/** Add your docs here. */
public class JoystickAxis extends Button{
    private final GenericHID m_joystick;
    private final int m_axisNumber;
    
    public JoystickAxis(GenericHID Joystick, int axisNumber){
        m_joystick = Joystick;
        m_axisNumber = axisNumber;
    }

    @Override
    public boolean get() {
      return m_joystick.getRawAxis(m_axisNumber) > 0;
    }
}

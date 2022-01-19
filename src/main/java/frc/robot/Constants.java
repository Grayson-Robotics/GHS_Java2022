// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    
    //most motors are labeled 0 right now as a placeholder until the robot and electronics are finished.
    
    //This sub-class holds the ports for any motors required to drive.
    public final class driveMotors{
        public static final int m_topLeft = 0;
        public static final int m_bottomLeft = 1;
    
        public static final int m_topRight = 2;
        public static final int m_bottomRight = 3;
    }
    
    // This holds what channel certain solenoids are on.
    public final class solenoids{
        public static final int solenoid1 = 0;
        public static final int solenoid2 = 1;
    }
    
}

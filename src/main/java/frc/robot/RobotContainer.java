// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.driveCommand;
import frc.robot.commands.startCollect;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
 // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  
  private final Compressor compressor = new Compressor();
  private final DriveTrain driveTrain = new DriveTrain();
  
  final Joystick m_stick2 = new Joystick(0);
  final XboxController xbox = new XboxController(1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

   // m_chooser.setDefaultBoolean()
   // SmartDashboard.putData("auto modes", &m_chooser);
   //turn object buttons into boolean



   
    boolean bB = false;
    boolean bA = false;
    boolean bY = false;
    boolean bX = false;
    boolean RB = false;
    boolean LB = false;
    boolean RT = false;
    boolean LT = false;
    double stickx = 0.0;
    double sticky = 0.0;
    double stickz = 0.0;

    bA = xbox.getAButton();
    bY = xbox.getYButton();
    bX = xbox.getXButton();
    bB = xbox.getBButton();
    
     /*RB = xbox.getBumper();
    LB = xbox.getBumper();
    RT = xbox.getBumper();
    LT = xbox.getBumper();*/
    SmartDashboard.putBoolean("B", bB );
    SmartDashboard.putBoolean("A", bA );
    SmartDashboard.putBoolean("X", bX );
    /*SmartDashboard.putBoolean("Y", bY );
    SmartDashboard.putNumber(key, value)
    SmartDashboard.putNumber(key, value)
    SmartDashboard.putNumber(key, value)*/



   /* A.whenHeld(new Shooter(m_ShooterSubsystem, 1.0));
    B.whenHeld(new Scooper(m_ScooperSubsystem, -1.0));
    X.whenHeld(new shootscoop(m_ShooterSubsystem, m_ScooperSubsystem, -1.0, 0.5));
    R2.whenHeld(new shootscoop(m_ShooterSubsystem, m_ScooperSubsystem, -1.0, 0.5));
    LB.whenHeld(new TeleOpDrive(m_DriveSubsystem, 
    () -> (0),
    () -> (0)
    ));
    LT2.whenPressed(new PneumaticUp(m_PneumaticsSubsystem));
    LB2.whenPressed(new PneumaticDown(m_PneumaticsSubsystem));
    // Configure the button bindings*/
    
    compressor.start();
    compressor.setClosedLoopControl(true);

    configureButtonBindings();
    
    driveTrain.setDefaultCommand(new driveCommand(driveTrain , () -> m_stick2.getY(), () -> m_stick2.getX()));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final JoystickButton A = new JoystickButton(m_stick2 , 2);
    // final JoystickButton B = new JoystickButton(m_stick2, 3);
     final JoystickButton X = new JoystickButton(m_stick2, 1);
     final JoystickButton R2 = new JoystickButton(m_stick2, 8);
     final JoystickButton Y = new JoystickButton(m_stick2 ,4);
     //final JoystickButton LB = new JoystickButton(m_stick2, 5);
     final JoystickButton LB2 = new JoystickButton(m_stick2, 5);
     final JoystickButton LT2 = new JoystickButton(m_stick2, 7);
    
     X.whenHeld(new startCollect());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
 /* public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }*/
}

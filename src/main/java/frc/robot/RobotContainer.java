// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.commands.*;
import frc.robot.subclasses.JoystickAxis;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
 // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  
  private final DriveTrain driveTrain = new DriveTrain();
  private final Pneumatics pneumatics = new Pneumatics();
  private final Climber climber = new Climber();
  private final Shooter shooter = new Shooter();
  private final Elevator elevator = new Elevator();
  private final ArmMove arm = new ArmMove();
  private final Collector collect = new Collector();
  
  private ShuffleboardTab driveTab = Shuffleboard.getTab("drive");
  private NetworkTableEntry maxSpeed = driveTab.add("Max Speed", 1).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", 0, "max", 1)).getEntry();
  
  private double speed = maxSpeed.getDouble(0.75);

  private SendableChooser<Command> choose = new SendableChooser<>();
  
  private Compressor compress = new Compressor(PneumaticsModuleType.CTREPCM);

  final Joystick m_stick = new Joystick(0);
  final XboxController m_stick2 = new XboxController(1);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    choose.setDefaultOption("autoOn", new driveAuto(driveTrain, shooter, elevator));
    choose.addOption("autoOff", new dummyCommand());
    
    SmartDashboard.putData("auto modes", choose);
   //turn object buttons into boolean
   

    
    SmartDashboard.putBoolean("Compressor Running", compress.enabled());
    SmartDashboard.putBoolean("2A", m_stick2.getAButtonPressed());
    

    configureButtonBindings();
    
    driveTrain.setDefaultCommand(new driveCommand(driveTrain , () -> 0.65 * -(m_stick.getY()), () -> 0.65 *(m_stick.getRawAxis(4))));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final JoystickButton A = new JoystickButton(m_stick2 , 1);
    final JoystickButton B = new JoystickButton(m_stick2, 2);
    final JoystickButton X = new JoystickButton(m_stick2, 3);
    final JoystickButton Y = new JoystickButton(m_stick2 ,4);
    final JoystickButton L1 = new JoystickButton(m_stick, 5);
    final JoystickButton R1 = new JoystickButton(m_stick, 6);
    final JoystickButton d2L1 = new JoystickButton(m_stick2, 5);
    final JoystickButton d2R1 = new JoystickButton(m_stick2, 6);
    final JoystickAxis L2 = new JoystickAxis(m_stick2, 2);
    final JoystickAxis R2 = new JoystickAxis(m_stick2, 3);
    final POVButton upAngle = new POVButton(m_stick2, 0); 
    final POVButton downAngle = new POVButton(m_stick2, 180); 

//If thy lay thyeth eyes on to code, thy must accept the grace ofeth truth. Thou haft no maidens, thou art maidenless.//
 
    X.toggleWhenPressed(new toggleSolenoid(pneumatics));
    A.whenHeld(new sendClimbArmDown(climber));
    Y.whenHeld(new sendClimbArmUp(climber));
    L1.whenHeld(new armUp(arm));
    R1.whenHeld(new armDown(arm));
    
    d2L1.whenHeld(new armUp(arm));
    d2R1.whenHeld(new armDown(arm));
    
    L2.whenHeld(new runGrabber(collect));
    R2.whenHeld(new startShoot(shooter), true);
    upAngle.whenHeld(new grabElevate(elevator, collect));
    downAngle.whenHeld(new elevatorDown(elevator));
  }
  
  public DriveTrain getDriveTrain(){
    return driveTrain;
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
   
   public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return choose.getSelected();
  }
  
}

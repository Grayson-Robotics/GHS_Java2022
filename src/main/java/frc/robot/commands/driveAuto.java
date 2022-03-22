// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Elevator;

public class driveAuto extends CommandBase {
  public DriveTrain drive;
  public Shooter shoot_motor;
  public Elevator levitate;

  Timer time;

  /** Creates a new driveAuto. */
  public driveAuto(DriveTrain drive, Shooter shoot, Elevator elevate) {
    // Use addRequirements() here to declare subsystem dependencies.

    this.drive = drive;
    shoot_motor = shoot;
    levitate = elevate;

    addRequirements(drive, shoot, elevate);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time = new Timer();
    time.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    if(time.get() > 0 && time.get() < 1){
      shoot_motor.set(1);
    }
    if(time.get() > 1 && time.get() < 3){
      shoot_motor.set(1);
      levitate.bringUp();
    }
    if(time.get() > 3 && time.get() < 5){
      drive.drive(-0.9, 0);
      shoot_motor.set(0);
      levitate.set(0);
      
    }
    
    //drive.drive(0.9, 0);
  }

  // Called once the comm                                                                                 //0/// / /00...0..0and ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.drive(0, 0);
    shoot_motor.set(0);
    levitate.set(0);
    time.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return time.get() > 5;
  }
}

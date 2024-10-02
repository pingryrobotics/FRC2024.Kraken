// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



import frc.robot.constants.ControllerConstants;
import frc.robot.constants.DriveConstants;
import frc.robot.subsystems.Drivetrain;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;


public class RobotContainer {

  // Instantiate subsystems
  private final Drivetrain drivetrain = new Drivetrain(DriveConstants.CONFIG_FOLDER);
  //private final Intake intake = new Intake();
  //private final Shooter shooter = new Shooter();


  
  private final CommandPS5Controller DriverController = new CommandPS5Controller(ControllerConstants.DRIVER_CONTROLLER_PORT);
  private final CommandPS5Controller OperatorController = new CommandPS5Controller(ControllerConstants.OPERATOR_CONTROLLER_PORT);


  public RobotContainer() {
    // Configure the trigger bindings
    configureDriverBindings();
    configureOperatorBindings();
      
    drivetrain.setDefaultCommand(Commands.run(() -> {drivetrain.setInputFromController(DriverController);}, drivetrain));
  }
  private void configureDriverBindings() {
    
  }
  private void configureOperatorBindings() {
    
  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Commands.none();
  }
}

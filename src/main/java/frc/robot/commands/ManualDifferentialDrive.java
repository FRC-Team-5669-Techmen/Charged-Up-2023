// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import frc.robot.subsystems.Drivetrain;
import frc.robot.Constants.DrivetrainConstants;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ManualDifferentialDrive extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final Drivetrain m_drivetrain;

  private final DoubleSupplier forwardSpeed, rotationalSpeed;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ManualDifferentialDrive(DoubleSupplier forwardSpeed, DoubleSupplier rotationalSpeed, Drivetrain subsystem) {
    m_drivetrain = subsystem;
    addRequirements(subsystem);
    this.forwardSpeed = forwardSpeed;
    this.rotationalSpeed = rotationalSpeed;
  }

  public double mapNonLinearly(double input) {
    return Math.pow(Math.abs(input), 1/DrivetrainConstants.NONLINEAR_EFFECT) * Math.signum(input);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.print(forwardSpeed);
    m_drivetrain.driveDifferential(mapNonLinearly(forwardSpeed.getAsDouble()), mapNonLinearly(rotationalSpeed.getAsDouble()));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Constants.WristConstants;
import frc.robot.subsystems.WristSubsystem;

public class PullWrist extends CommandBase{
    private final WristSubsystem wrist;
    
    public PullWrist( WristSubsystem wrist) {
        setName("Retract Wrist");
        this.wrist = wrist;
        addRequirements(this.wrist);
    }

    @Override
    public void initialize() {
        wrist.wristMotorPull();
    }
    @Override
    public void execute() {
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        wrist.stopWristMotor();
    }
}

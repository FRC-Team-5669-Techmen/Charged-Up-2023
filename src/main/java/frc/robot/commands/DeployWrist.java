package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.WristSubsystem;

public class DeployWrist extends InstantCommand{
    private final WristSubsystem wrist;
    
    public DeployWrist( WristSubsystem wrist) {
        setName("Deploy Wrist");
        this.wrist = wrist;
        addRequirements(this.wrist);
    }

    @Override
    public void initialize() {
        wrist.deployWrist();
    }
}

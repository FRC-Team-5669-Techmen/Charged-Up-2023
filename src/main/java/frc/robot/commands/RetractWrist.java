package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.WristSubsystem;

public class RetractWrist extends InstantCommand{
    private final WristSubsystem wrist;
    
    public RetractWrist( WristSubsystem wrist) {
        setName("Retract Wrist");
        this.wrist = wrist;
        addRequirements(this.wrist);
    }

    @Override
    public void initialize() {
        wrist.retractWrist();
    }
}

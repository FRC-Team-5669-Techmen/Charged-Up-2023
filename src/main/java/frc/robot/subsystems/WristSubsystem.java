package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

import frc.robot.Constants.PneumaticSystemConstants;

public class WristSubsystem extends SubsystemBase {
    Compressor pcmCompressor = new Compressor(0, PneumaticSystemConstants.PNEUMATIC_TYPE);
    private final DoubleSolenoid wristSolenoid = new DoubleSolenoid(PneumaticSystemConstants.PNEUMATIC_TYPE, PneumaticSystemConstants.FORWARD_VALVE, PneumaticSystemConstants.REVERSE_VALVE);

    public WristSubsystem() {
        super();
        pcmCompressor.enableDigital();
        
        wristSolenoid.set(kOff);
    }

    public void deployWrist(){
        wristSolenoid.set(kForward);
    }
    public void retractWrist() {
        wristSolenoid.set(kReverse);
    }
}

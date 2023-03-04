package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants.PneumaticSystemConstants;
import frc.robot.Constants.WristConstants;

public class WristSubsystem extends SubsystemBase {
    Compressor pcmCompressor = new Compressor(0, PneumaticSystemConstants.PNEUMATIC_TYPE);
    private final DoubleSolenoid wristSolenoid = new DoubleSolenoid(PneumaticSystemConstants.PNEUMATIC_TYPE, PneumaticSystemConstants.FORWARD_VALVE, PneumaticSystemConstants.REVERSE_VALVE);

    private final WPI_TalonSRX m_leftWristMotor = new WPI_TalonSRX(WristConstants.LEFT_WRIST_MOTOR);

    private final CANSparkMax m_wristAngleMotor1 = new CANSparkMax(WristConstants.WRIST_ANGLE_MOTOR_1, MotorType.kBrushless);
    private final CANSparkMax m_wristAngleMotor2 = new CANSparkMax(WristConstants.WRIST_ANGLE_MOTOR_2, MotorType.kBrushless);

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

    public void setWristMotor(double speed) {
        m_leftWristMotor.set(ControlMode.PercentOutput, speed);
    }
    public void wristMotorPush() {
        m_leftWristMotor.set(ControlMode.PercentOutput, .5);
    }
    public void wristMotorPull() {
        m_leftWristMotor.set(ControlMode.PercentOutput, -.5);
    }

    public void stopWristMotor() {
        m_leftWristMotor.set(0);
    }

    public void stopWristAngle() {
        m_wristAngleMotor1.set(0);
        m_wristAngleMotor2.set(0);
    }

    public void wristAngleUp() {
        m_wristAngleMotor1.set(.2);
        m_wristAngleMotor2.set(.2);
    }

    public void wristAngleDown() {
        m_wristAngleMotor1.set(-.2);
        m_wristAngleMotor2.set(-.2);
    }
}

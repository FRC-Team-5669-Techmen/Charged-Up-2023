package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants.ElevatorConstants;

public class ElevatorSubsystem extends SubsystemBase {
    
    private final CANSparkMax m_elevatorMotor1 = new CANSparkMax(ElevatorConstants.ELEVATOR_MOTOR_1, MotorType.kBrushless);
    private final CANSparkMax m_elevatorMotor2 = new CANSparkMax(ElevatorConstants.ELEVATOR_MOTOR_2, MotorType.kBrushless);

    //DigitalInput toplimitSwitch = new DigitalInput(0);
    //DigitalInput bottomlimitSwitch = new DigitalInput(1);


    public ElevatorSubsystem() {
        super();
        
    }

    public void setElevatorMotor(double speed) {
        if(topLimitSwitchPressed()) {
            stopElevator();
            return;
        }
        m_elevatorMotor1.set(speed);
        m_elevatorMotor2.set(speed);
    }
    public void raiseElevator() {
        setElevatorMotor(.05);
    }
    public void lowerElevator() {
        setElevatorMotor(-.1);
    }

    public void stopElevator() {
        m_elevatorMotor1.set(0);
        m_elevatorMotor2.set(0);
    }

    public boolean topLimitSwitchPressed() {
        //return toplimitSwitch.get();
        return false;
    }
    public boolean bottomLimitSwitchPressed() {
        //return bottomlimitSwitch.get();
        return false;
    }

}

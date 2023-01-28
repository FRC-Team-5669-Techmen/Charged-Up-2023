// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SubsystemBase {
    private final WPI_VictorSPX m_backLeftMotor = new WPI_VictorSPX(DrivetrainConstants.BACK_LEFT_MOTOR);
    private final WPI_VictorSPX m_backRightMotor = new WPI_VictorSPX(DrivetrainConstants.BACK_RIGHT_MOTOR);
    private final WPI_VictorSPX m_frontLeftMotor = new WPI_VictorSPX(DrivetrainConstants.FRONT_LEFT_MOTOR);
    private final WPI_VictorSPX m_frontRightMotor = new WPI_VictorSPX(DrivetrainConstants.FRONT_RIGHT_MOTOR);

    private final MotorControllerGroup m_leftMotors = new MotorControllerGroup(m_backLeftMotor, m_frontLeftMotor);
    private final MotorControllerGroup m_rightMotors = new MotorControllerGroup(m_backRightMotor, m_frontRightMotor);

    DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);

    public Drivetrain() {
        super();
        m_leftMotors.setInverted(true);
        m_drive.setDeadband(0.05);
        m_drive.setMaxOutput(1);
    }

    public void driveDifferential(double forwardSpeed, double rotationalSpeed) {
        m_drive.arcadeDrive(forwardSpeed, rotationalSpeed);
    }

    public void brake() {
        m_drive.arcadeDrive(0, 0);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}

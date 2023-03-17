// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static class DrivetrainConstants {
    public static final int BACK_LEFT_MOTOR = 2;
    public static final int BACK_RIGHT_MOTOR = 1;
    public static final int FRONT_LEFT_MOTOR = 3;
    public static final int FRONT_RIGHT_MOTOR = 4;
    public static final double NONLINEAR_EFFECT = 3;
    public static final double DRIVE_SPEED = 0.5;
  }

  public static class WristConstants {
    public static final int LEFT_WRIST_MOTOR = 5;
    public static final int RIGHT_WRIST_MOTOR = 6;
    public static final float WRIST_SPEED = 1;
    public static final int WRIST_ANGLE_MOTOR_1 = 9;
    public static final int WRIST_ANGLE_MOTOR_2 = 10;
  }

  public static class ElevatorConstants {
    public static final int ELEVATOR_MOTOR_1 = 7;
    public static final int ELEVATOR_MOTOR_2 = 8;
  }

  public static class ControlSystemConstants {
    public static final int CONTROLLER_PORT = 1;
  }
  public static class PneumaticSystemConstants {
    public static final PneumaticsModuleType PNEUMATIC_TYPE = PneumaticsModuleType.CTREPCM;
    public static final int FORWARD_VALVE = 0;
    public static final int REVERSE_VALVE = 1;
  }
}

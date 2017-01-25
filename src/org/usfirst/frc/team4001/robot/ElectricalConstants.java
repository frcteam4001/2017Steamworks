/**
 * 
 */
package org.usfirst.frc.team4001.robot;

/**
 * @author eric
 *
 * ElectricalConstants is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class ElectricalConstants {
	
	// ************************************************************************
	// **************************  GEARDROP  **********************************
	// ************************************************************************
	
	public static final int GEARDROP_MOTOR_LEFT			= 7;  // CAN
	public static final int GEARDROP_MOTOR_RIGHT 		= 6;  // CAN
	
	public static final int GEARDROP_SWITCH_LEFT		= 0;  // DIO
	public static final int GEARDROP_SWITCH_RIGHT		= 1;  // DIO
	
	public static final int GEARDROP_FENCE_LEFT			= -1;  // to be set
	public static final int GEARDROP_FENCE_RIGHT		= -1;  // to be set
	public static final int GEARDROP_ROLLER 			= 5;   // CAN
	
	// ************************************************************************
	// **************************  DRIVETRAIN  ********************************
	// ************************************************************************
	public static final int DRIVETRAIN_FRONT_LEFT 				= 3;  // CAN
	public static final int DRIVETRAIN_FRONT_RIGHT 				= 1;  // CAN
	public static final int DRIVETRAIN_REAR_LEFT				= 4;  // CAN
	public static final int DRIVETRAIN_REAR_RIGHT 				= 2;  // CAN
	
	public static final int DRIVETRAIN_ULTRASONIC_LEFT			= 0;  // ANALOG
	public static final int DRIVETRAIN_ULTRASONIC_RIGHT 		= 1;  // ANALOG
	
	
	

}

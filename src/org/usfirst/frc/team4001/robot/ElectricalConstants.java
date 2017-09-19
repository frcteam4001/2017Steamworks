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
	
	
	public static final int GEARDROP_ROLLER 			= 5;   // CAN
	public static final int GEARDROP_IR_SENSOR			= 0; // ANALOG
	

	public static final int GEARDROP_PUSHER_OUT			= 0; 
	public static final int GEARDROP_PUSHER_IN			= 1;
	public static final int PUSHER_SWITCH				= 2;

	
	// ************************************************************************
	// **************************  CURTAIN  **********************************
	// ************************************************************************
	
	public static final int CURTAIN_MOTOR		= 0; // PWM
	public static final int CURTAIN_POT			= 3; // ANALOG

	
	// ************************************************************************
	// **************************  DRIVETRAIN  ********************************
	// ************************************************************************
	public static final int DRIVETRAIN_FRONT_LEFT 				= 3;  // CAN
	public static final int DRIVETRAIN_FRONT_RIGHT 				= 1;  // CAN
	public static final int DRIVETRAIN_REAR_LEFT				= 4;  // CAN
	public static final int DRIVETRAIN_REAR_RIGHT 				= 2;  // CAN
	

	public static final int DRIVETRAIN_ULTRASONIC_LEFT			= 1;  // ANALOG
	public static final int DRIVETRAIN_ULTRASONIC_RIGHT 		= 2;  // ANALOG

	
	public static final boolean DRIVETRAIN_FRONT_LEFT_REVERSE	= true;
	public static final boolean DRIVETRAIN_FRONT_RIGHT_REVERSE	= true;
	public static final boolean DRIVETRAIN_REAR_LEFT_REVERSE	= true;
	public static final boolean DRIVETRAIN_REAR_RIGHT_REVERSE	= true;
	
	//***************************************************************************
	//************************* GEARDROP ENCODER CONSTANTS *************************
	//***************************************************************************
	
	//this needs to be set accordingly for distance calculations
	public static final int driveWheelRadius		 			= 3;//wheel radius in inches
	public static final int drivePulsePerRotation 				= 1024; //encoder pulse per rotation
	public static final double driveGearRatio 					= 1/1; //ratio between wheel and encoder
	public static final double driveEncoderPulsePerRot 			= drivePulsePerRotation*driveGearRatio; //pulse per rotation * gear ratio
	public static final double driveEncoderDistPerTick 			=(Math.PI*2*driveWheelRadius)/driveEncoderPulsePerRot;
	public static final boolean leftDriveTrainEncoderReverse 	= true;
	public static final boolean rightDriveTrainEncoderReverse 	= false;
	
	
	//***************************************************************************
	//****************************** DRIVE ENCODERS *****************************
	//***************************************************************************
	
	public static final int LEFT_DRIVE_ENCODER_A                            = 8;
	public static final int LEFT_DRIVE_ENCODER_B                            = 9;
	
	public static final int RIGHT_DRIVE_ENCODER_A                           = 6;
	public static final int RIGHT_DRIVE_ENCODER_B                           = 7;
	
	//*************************************************************************** 
	//****************************** CLIMBERS ***********************************
	//***************************************************************************
	

	public static final int CLIMBER_MOTOR                                   = 1; //PWM

	
}

package org.usfirst.frc.team4001.robot;

/*
 * @author Eric Fabroa
 * 
 * Used to store various constants used throughout the robot i.e speed settings, pid values
 * 
 */


public class NumberConstants {
	//**************************************************************************
    //***************************** GEARDROP/Intake *****************************
    //**************************************************************************
	
	public static final double geardrop_openpower 						 = 0.5;
	
	// pid constants for gear holder
	public static final double geardrop_holder_close_p					 = 0.9;
	public static final double geardrop_holder_close_i					 = 0.0;
	public static final double geardrop_holder_close_d					 = 0.3;
	public static final double geardrop_holder_close_f					 = 0.0;
	public static final int geardrop_holder_close_error					 = 100;
	public static final int geardrop_holder_close_position				 = 15900; //pulses

	

	//placement zones in pulses
	public static final int geardrop_zone1 								= 15200;	// far left position
	public static final int geardrop_zone2								= 11400;
	public static final int geardrop_zone3								= 7600;
	public static final int geardrop_zone4								= 3800;
	public static final int geardrop_zone5								= 0;		// the far right position
	
	
	


	//The maximum reading from the IR sensor when a gear is in place
	public static final int IR_sensor_treshold							 = -1; 	// to be set
	
	//The distance to the airship from which the image must be captured
	public static final double camera_capture_distance					 = 36 + 3; // inches
	
	public static final double distance_from_loading_station			 = 4; // inches

	//**************************************************************************
    //*************************** PID VALUES (DRIVE) ***************************
    //**************************************************************************
	
	//Competition
	public static final double pDrive 									 = 0.15;
	public static final double iDrive 									 = 0.00;
	public static final double dDrive 									 = 0.04;
	
	public static final double Drive_Scale 								 = 0.6;
	
	//**************************************************************************
    //******************************* CURTAIN **********************************
    //**************************************************************************
	
	public static final double curtain_max = 130;
	public static final double curtain_min  = 9;
	public static final double curtain_speed = 0.8;
	
	//**************************************************************************
    //******************************* CLIMBER **********************************
    //**************************************************************************
	public static final double climber_upSpeed = 1;
	public static final double climber_downSpeed = 0.5;
	
	//**************************************************************************
    //**************************** PID VALUES (GYRO) ***************************
    //**************************************************************************
	
	//Competition
	public static final double pGyro 									 = 0.025;
	public static final double iGyro 									 = 0.00;
	public static final double dGyro 									 = 0.00;
	
	//**************************************************************************
    //************************* ULTRASONIC CALCULATIONS ************************
    //**************************************************************************
	
	public static final double distance_between_sensors					 = 28; //inches
	
	//The maximum reading difference, in inches, for the sensors to be considered fixed on the
	//surface. If the difference is greater, the sensors are fixed on different surfaces
	public static final double max_ultrasonic_reading_difference		 = 20; //inches
	
	//The magnitude of the angle at which the robot must turn when sensors are not pointing at
	//the same surface.
	public static final double blind_turn_angle							 = 15; //degrees
	
	//The maximum difference between the two ultrasonic readings that would be considered
	//"aligned"
	public static final double aligned_tolerance						 = 1; //inches

}

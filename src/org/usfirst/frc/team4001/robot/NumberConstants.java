package org.usfirst.frc.team4001.robot;

/*
 * @author Eric Fabroa
 * 
 * Used to store various constants used throughout the robot i.e speed settings, pid values
 * 
 */


public class NumberConstants {
	//**************************************************************
	//************************  GEARDROP  **************************
	//**************************************************************/
	
	public static final double geardrop_openpower = 			0.5;
	
	// pid constants for gear holder close
	public static final double geardrop_holder_close_p = 0.9;
	public static final double geardrop_holder_close_i = 0.0;
	public static final double geardrop_holder_close_d = 0.3;
	public static final double geardrop_holder_close_f = 0.0;
	public static final int geardrop_holder_close_error = 0;
	public static final int geardrop_holder_close_position = 15200; //pulses

	//**************************************************************************
    //*************************** PID VALUES (DRIVE) ***************************
    //**************************************************************************
	
	//Competition
	public static final double pDrive 									 = 0.05;
	public static final double iDrive 									 = 0.00;
	public static final double dDrive 									 = 0.008;
	
	public static final double Drive_Scale 								 = 0.6;
	
	//**************************************************************************
    //**************************** PID VALUES (GYRO) ***************************
    //**************************************************************************
	
	//Competition
	public static final double pGyro 									 = 0.0125;
	public static final double iGyro 									 = 0.00;
	public static final double dGyro 									 = 0.00;


}

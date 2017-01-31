package org.usfirst.frc.team4001.robot.subsystems;


import org.usfirst.frc.team4001.robot.ElectricalConstants;
import com.team4001.lib.util.PIDController;
import org.usfirst.frc.team4001.robot.commands.ArcadeDrive;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import com.ctre.*;
import org.usfirst.frc.team4001.robot.NumberConstants;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // motors
	private final CANTalon frontLeftMotor;
	private final CANTalon frontRightMotor;
	private final CANTalon rearLeftMotor;
	private final CANTalon rearRightMotor;
	
	private final RobotDrive drive;
		
	// ultrasonic sensors
	private final AnalogInput ultrasonic_left;
	private final AnalogInput ultrasonic_right;
	//private final Potentiometer pot = new AnalogPotentiometer(1,10,0);
	
	//Gyro
	private final ADXRS450_Gyro gyro;
	
	//PID controllers
	public PIDController drivePID;
	public PIDController gyroPID;
	
	
	public DriveTrain() {
		//initialize motors
		frontLeftMotor = new CANTalon(ElectricalConstants.DRIVETRAIN_FRONT_LEFT);
		frontRightMotor = new CANTalon(ElectricalConstants.DRIVETRAIN_FRONT_RIGHT);
		rearLeftMotor = new CANTalon(ElectricalConstants.DRIVETRAIN_REAR_LEFT);
		rearRightMotor = new CANTalon(ElectricalConstants.DRIVETRAIN_REAR_RIGHT);
		
		//initialize Drive Train
		drive = new RobotDrive(frontLeftMotor, rearLeftMotor,frontRightMotor , rearRightMotor);
		
		//initialize ultrasonic sensors
		ultrasonic_left = new AnalogInput(ElectricalConstants.DRIVETRAIN_ULTRASONIC_LEFT);
		ultrasonic_right = new AnalogInput(ElectricalConstants.DRIVETRAIN_ULTRASONIC_RIGHT);
		//private final Potentiometer pot = new AnalogPotentiometer(1,10,0);
		
		//initialize gyro
		gyro = new ADXRS450_Gyro();
		
		//initialize PID controllers
		drivePID = new PIDController(NumberConstants.pDrive, NumberConstants.iDrive, NumberConstants.dDrive);
		gyroPID = new PIDController(NumberConstants.pGyro, NumberConstants.iGyro, NumberConstants.dGyro);
	}
	
	
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new ArcadeDrive());
    }
    
    
    public void arcadeDrive(double forward, double turn){
    	drive.arcadeDrive(forward, turn,false);

    } 
    
    public void hardStop() {
    	drive.arcadeDrive(0, 0);
    }
    
    
    
    
}


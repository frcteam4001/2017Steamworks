package org.usfirst.frc.team4001.robot.subsystems;


import org.usfirst.frc.team4001.robot.ElectricalConstants;
//import org.usfirst.frc.team4001.robot.commands.ArcadeDrive;

import com.ctre.*;
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
	private final CANTalon frontLeftMotor = new CANTalon(ElectricalConstants.DRIVETRAIN_FRONT_LEFT);
	private final CANTalon frontRightMotor = new CANTalon(ElectricalConstants.DRIVETRAIN_FRONT_RIGHT);
	private final CANTalon rearLeftMotor = new CANTalon(ElectricalConstants.DRIVETRAIN_REAR_LEFT);
	private final CANTalon rearRightMotor = new CANTalon(ElectricalConstants.DRIVETRAIN_REAR_RIGHT);
	
	// ultrasonic sensors
	private final AnalogInput ultrasonic_left = new AnalogInput(ElectricalConstants.DRIVETRAIN_ULTRASONIC_LEFT);
	private final AnalogInput ultrasonic_right = new AnalogInput(ElectricalConstants.DRIVETRAIN_ULTRASONIC_RIGHT);
	//private final Potentiometer pot = new AnalogPotentiometer(1,10,0);
	
	private final RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor,frontRightMotor , rearRightMotor);
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	//setDefaultCommand(new ArcadeDrive());
    }
    
    
    public void arcadeDrive(double forward, double turn){
    	drive.arcadeDrive(forward, turn,false);

    } 
    
    
    
    
    
    
}


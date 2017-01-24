package org.usfirst.frc.team4001.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4001.robot.RobotMap;
import com.ctre.CANTalon;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final CANTalon frontLeftMotor = new CANTalon(RobotMap.front_left_motor);
	private final CANTalon rearLeftMotor = new CANTalon(RobotMap.rear_left_motor);
	private final CANTalon frontRightMotor = new CANTalon(RobotMap.front_right_motor);
	private final CANTalon rearRightMotor = new CANTalon(RobotMap.rear_right_motor);
	private final AnalogGyro gyro = new AnalogGyro(RobotMap.gyro);
	
	private final RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor,frontRightMotor , rearRightMotor);
	
	//keep tract of if the angle had been reseted, for driving continuous stright line
	private boolean reseted = false;
	//a really small value, use to turn steering back to parallel
	private static final double change = 0.05;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void drive(double foward, double turn)
    {
    	if(turn == 0)//if turning value is zero
    	{
    		if(reseted == false)
    		{
    			resetangle();
    			drivestraight(foward);
    		}
    		else
    		{
    			drivestraight(foward);
    		}
    	}
    	else
    	{
    		//drives the robot
    		drive.arcadeDrive(foward, turn, false);
    		reseted = false;
    	}
    }
    
    private void resetangle()
    {
    	gyro.reset();
    	reseted = true;
    }
    
    private void drivestraight(double f)
    {
    	double gyroinput = gyro.getAngle();
    	
    	if(gyroinput < 0)//if the robot is tilted left
    	{
    		drive.arcadeDrive(f, change);//change can also be scaled by the angle
    	}
    	else if(gyroinput > 0)//if the robot is tilted right
    	{
    		drive.arcadeDrive(f, -change);
    	}
    	else
    	{
    		drive.arcadeDrive(f, 0);
    	}
    }
    
    //stops the robot
    public void hardstop()
    {
    	drive.arcadeDrive(0, 0);
    }
}


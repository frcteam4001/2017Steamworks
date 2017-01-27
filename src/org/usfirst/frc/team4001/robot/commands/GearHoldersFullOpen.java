package org.usfirst.frc.team4001.robot.commands;

import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4001.robot.NumberConstants;;

/**
 * Move both gear holders to the full open position. Optionally calibrates encoders
 */
public class GearHoldersFullOpen extends Command {
	
	private boolean calibrate;

    public GearHoldersFullOpen() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.geardrop);	
    }
    
    /**
     * Alternative constructor with option to calibrate the encoders after full open
     * 
     * @param calibrateTF
     * 		if true, calibrate the motor encoders
     */	
    public GearHoldersFullOpen(Boolean calibrateTF){
    	requires(Robot.geardrop);
    	calibrate = calibrateTF;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.geardrop.enablePowerMode();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!Robot.geardrop.leftswitchpressed()){
    		Robot.geardrop.openLeftHolder(NumberConstants.geardrop_openpower);
    	}
    	else{
    		Robot.geardrop.stopLeftHolder();	
    	}
    	
    	if(!Robot.geardrop.rightswitchpressed()){
    		Robot.geardrop.openRightHolder(NumberConstants.geardrop_openpower);
    	}
    	else{
    		Robot.geardrop.stopRightHolder();
    	}
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.geardrop.leftswitchpressed() && Robot.geardrop.rightswitchpressed();
    }
    

    // Called once after isFinished returns true
    protected void end() {
    	if(calibrate){
    		//reset the encoders
    		System.out.println("calibrating");
    		Robot.geardrop.resetEncoders();
 
    	}
    }
    

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

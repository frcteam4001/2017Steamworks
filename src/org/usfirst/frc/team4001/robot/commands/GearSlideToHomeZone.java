package org.usfirst.frc.team4001.robot.commands;

import org.usfirst.frc.team4001.robot.NumberConstants;
import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearSlideToHomeZone extends Command {

    public GearSlideToHomeZone() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.geardrop);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	

    		Robot.geardrop.pairHolders();
        	Robot.geardrop.pid_initRightPosition(NumberConstants.geardrop_holder_close_p, NumberConstants.geardrop_holder_close_i, NumberConstants.geardrop_holder_close_d, NumberConstants.geardrop_holder_close_f, NumberConstants.geardrop_holder_close_error, false, NumberConstants.geardrop_slide_peakvolage);       	

        	Robot.geardrop.slideToZone(NumberConstants.geardrop_home_zone);
        	
        	
        	
   
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
 
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//System.out.println("GearSlideToZone is Finished");
    	
        return Robot.geardrop.pid_rightPositionReached();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}

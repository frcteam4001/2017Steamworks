package org.usfirst.frc.team4001.robot.commands;

import org.usfirst.frc.team4001.robot.NumberConstants;
import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearSlidetoZoneManualRight extends Command {
	
	//private int timeOut;

    public GearSlidetoZoneManualRight()
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//System.out.println("ManualGearDropLeft: constructor() calling");
    	requires(Robot.geardrop);
    	//System.out.println("ManualGearDropLeft: constructor() called");
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	//this.timeOut = 2;
    	//setTimeout(this.timeOut);
    	if (!Robot.geardrop.get_HoldersOpened()){
    		if (!Robot.geardrop.get_HoldersPaired()){
    			System.out.println("pairing");
        		Robot.geardrop.pairHolders();
        	}
    		
    		System.out.println("pairing");
        	Robot.geardrop.pid_initRightPosition(NumberConstants.geardrop_holder_close_p, NumberConstants.geardrop_holder_close_i, NumberConstants.geardrop_holder_close_d, NumberConstants.geardrop_holder_close_f, NumberConstants.geardrop_holder_close_error, false, NumberConstants.geardrop_slide_peakvolage);       	
        	System.out.println("sliding");
        	Robot.geardrop.slideZoneRight();
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
    	return Robot.geardrop.pid_rightPositionReached() || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    	
    }
}
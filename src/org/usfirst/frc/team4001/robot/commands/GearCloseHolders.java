package org.usfirst.frc.team4001.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4001.robot.*;

/**
 *
 */
public class GearCloseHolders extends Command {
	
	private boolean isStart;

    public GearCloseHolders() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.geardrop);
    	isStart = true;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	if(this.isStart){
    		Robot.geardrop.pid_initRightPosition(NumberConstants.geardrop_holder_close_p, NumberConstants.geardrop_holder_close_i, NumberConstants.geardrop_holder_close_d, NumberConstants.geardrop_holder_close_f, NumberConstants.geardrop_holder_close_error, true);
    		
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!Robot.geardrop.leftswitchpressed()){
    		Robot.geardrop.openLeftHolder(NumberConstants.geardrop_openpower);
    		System.out.println("resetting left holder");
    		
    	}else{
    		System.out.println("moving right to position ...");
    		Robot.geardrop.pid_moveRightToPosition(NumberConstants.geardrop_holder_close_position);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	if(this.isStart){
    		if(!Robot.geardrop.leftswitchpressed() || !Robot.geardrop.rightswitchpressed()){
    			// cannot close since one of the holders is not in open position
    			return true;
    			
    		}else{
    			this.isStart = false;  //toggle start flag
    			return false;
    		}
    	}
    	
        return Robot.geardrop.pid_rightPositionReached();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.geardrop.set_closed(true);
    	Robot.geardrop.pairHolders();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

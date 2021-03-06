package org.usfirst.frc.team4001.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4001.robot.*;

/**
 *
 */
public class GearCloseHolders extends Command {
	
	private boolean isStart;
	private int timeOut;
	private boolean resetRightEncoder;

    public GearCloseHolders() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.geardrop);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.isStart = true;
    	this.timeOut = 2;
    	setTimeout(this.timeOut);
    	if(this.isStart){
    		
    		if(Robot.geardrop.rightswitchpressed()){
    			this.resetRightEncoder = true;
    		}else{
    			this.resetRightEncoder = false;
    		}
    		
    		
    		Robot.geardrop.pid_initRightPosition(NumberConstants.geardrop_holder_close_p, NumberConstants.geardrop_holder_close_i, NumberConstants.geardrop_holder_close_d, NumberConstants.geardrop_holder_close_f, NumberConstants.geardrop_holder_close_error, this.resetRightEncoder, NumberConstants.geardrop_close_peakvoltage);
    	}
    	
    	//if(Robot.geardrop.leftswitchpressed() && Robot.geardrop.rightswitchpressed()){
    	//	Robot.geardrop.resetEncoders();
    	//}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.pusher.pusherIsBack()){
    		if(!Robot.geardrop.leftswitchpressed()){
    			Robot.geardrop.openLeftHolder(NumberConstants.geardrop_openpower);
    			System.out.println("resetting left holder");
    		
    		}else{
    			Robot.geardrop.pid_moveRightToPosition(NumberConstants.geardrop_holder_close_position);
    		}
    	} else {
    		Robot.pusher.pusherIn();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {	
    	if(this.isStart){
    		if(!Robot.geardrop.leftswitchpressed() || !Robot.geardrop.rightswitchpressed()){
    			// cannot close since one of the holders is not in open position
    			System.out.println("1");	
    			return true;
    				
    			
    		}else{
    			this.isStart = false;  //toggle start flag
    			System.out.println("2");
    			return false;
    		}
    	}
    	System.out.println("3");
        return Robot.geardrop.pid_rightPositionReached() || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Gear close end()");
    	Robot.geardrop.set_closed(true);
    	Robot.geardrop.resetCurrentZone_value(1);
    	
    	//Robot.geardrop.stopLeftHolder();
    	//Robot.geardrop.stopRightHolder();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//Robot.geardrop.stopLeftHolder();
    	//Robot.geardrop.stopRightHolder();
    	
    }
}

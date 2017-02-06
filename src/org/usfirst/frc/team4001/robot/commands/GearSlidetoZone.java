package org.usfirst.frc.team4001.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4001.robot.*;


/**
 *
 */
public class GearSlidetoZone extends Command {
	
	private int zonePosition;

    public GearSlidetoZone() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.geardrop);
    	zonePosition = -1;
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    		Robot.geardrop.pairHolders();
        	Robot.geardrop.pid_initRightPosition(NumberConstants.geardrop_holder_close_p, NumberConstants.geardrop_holder_close_i, NumberConstants.geardrop_holder_close_d, NumberConstants.geardrop_holder_close_f, NumberConstants.geardrop_holder_close_error, false);       	
        	
        	switch((int) Robot.gearZone){
        	case 1:	this.zonePosition = NumberConstants.geardrop_zone1;
        			break;
        	case 2:	this.zonePosition = NumberConstants.geardrop_zone2;
        			break;
        	case 3:	this.zonePosition = NumberConstants.geardrop_zone3;
        			break;
        	case 4:	this.zonePosition = NumberConstants.geardrop_zone4;
        			break;
        	case 5:	this.zonePosition = NumberConstants.geardrop_zone5;   
        		 	break;
        	}
   
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.geardrop.get_HoldersPaired()){
    		System.out.println("Execute Slide to Position: " + Integer.toString(this.zonePosition));
        	Robot.geardrop.pid_moveRightToPosition(this.zonePosition);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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

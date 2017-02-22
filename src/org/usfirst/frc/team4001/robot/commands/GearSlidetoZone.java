package org.usfirst.frc.team4001.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4001.robot.*;


/**
 *
 */
public class GearSlidetoZone extends Command {
	
	


    public GearSlidetoZone() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.geardrop);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	
    		int target_zone;
    		
    		target_zone = (int)Robot.gearZone;

    		Robot.geardrop.pairHolders();
        	Robot.geardrop.pid_initRightPosition(NumberConstants.geardrop_holder_close_p, NumberConstants.geardrop_holder_close_i, NumberConstants.geardrop_holder_close_d, NumberConstants.geardrop_holder_close_f, NumberConstants.geardrop_holder_close_error, false);       	
        	
        	
        	/*
        	 *  	 
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
        	*/
        	
        	if(target_zone >= 1 && target_zone <=5){
        		Robot.geardrop.slideToZone((int)Robot.gearZone);
        	}
        	
        	
   
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
 
    	//Robot.geardrop.slideToZone((int)Robot.gearZone);
    	
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

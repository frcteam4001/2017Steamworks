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
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.gearZone == -1.0){
    		end();
    		
    	}else if (!Robot.geardrop.get_closed()){
    		end();
    			
    	}else{    		
    		Robot.geardrop.pairHolders();
        	Robot.geardrop.pid_initRightPosition(NumberConstants.geardrop_holder_close_p, NumberConstants.geardrop_holder_close_i, NumberConstants.geardrop_holder_close_d, NumberConstants.geardrop_holder_close_f, NumberConstants.geardrop_holder_close_error, false);
        	switch((int) Robot.gearZone){
        	case 1:
        		this.zonePosition = NumberConstants.geardrop_zone1;
        	case 2:
        		this.zonePosition = NumberConstants.geardrop_zone2;
        	case 3:
        		this.zonePosition = NumberConstants.geardrop_zone3;
        	case 4:
        		this.zonePosition = NumberConstants.geardrop_zone4;
        	case 5:
        		this.zonePosition = NumberConstants.geardrop_zone5;      	
        	}
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.geardrop.pid_moveRightToPosition(this.zonePosition);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

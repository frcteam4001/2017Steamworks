package org.usfirst.frc.team4001.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4001.robot.*;

/**
 *
 */
public class GearSlideToPulsePosition extends Command {
	
	private int pulsePosition;
	

    public GearSlideToPulsePosition() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.geardrop);
    }
    
    public GearSlideToPulsePosition(int inPosition) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.geardrop);
    	this.pulsePosition = inPosition;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.geardrop.pairHolders();
    	Robot.geardrop.pid_initRightPosition(NumberConstants.geardrop_holder_close_p, NumberConstants.geardrop_holder_close_i, NumberConstants.geardrop_holder_close_d, NumberConstants.geardrop_holder_close_f, NumberConstants.geardrop_holder_close_error, true, NumberConstants.geardrop_slide_peakvolage);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.geardrop.pid_moveRightToPosition(pulsePosition);
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

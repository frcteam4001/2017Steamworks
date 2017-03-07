package org.usfirst.frc.team4001.commands.auto;

import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearPusherOut extends Command {
	
	double timeOut;
	
    public GearPusherOut() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.geardrop);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.geardrop.pusherOut();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.geardrop.pusherIn();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.geardrop.pusherIn();
    }
}

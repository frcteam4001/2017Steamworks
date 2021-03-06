package org.usfirst.frc.team4001.robot.commands;

import org.usfirst.frc.team4001.robot.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PusherCommand extends Command {

    public PusherCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.pusher);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	if(Robot.geardrop.getCurrentZone() != 1 && Robot.geardrop.getCurrentZone() != 5){
    		Robot.pusher.pusherOut();
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

        return !Robot.oi.game_controller.getRightAxisButton().get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.pusher.pusherIn();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.pusher.pusherIn();
    }
}

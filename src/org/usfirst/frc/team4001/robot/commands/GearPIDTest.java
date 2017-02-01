package org.usfirst.frc.team4001.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4001.robot.Robot;

/**
 *
 */
public class GearPIDTest extends Command {
	
	

    public GearPIDTest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.geardrop);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.geardrop.pid_positionPrep();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("exec movetoposition");
    	//Robot.geardrop.moveToPosition(-6000);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return Robot.geardrop.positionReached();
    	return Robot.geardrop.leftswitchpressed();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

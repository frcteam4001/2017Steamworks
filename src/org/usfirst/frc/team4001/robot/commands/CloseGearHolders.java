package org.usfirst.frc.team4001.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4001.robot.*;

/**
 *
 */
public class CloseGearHolders extends Command {

    public CloseGearHolders() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.geardrop);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.geardrop.pid_initRightPosition(0.8, 0.0, 0.3, 0.0, 0, false);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!Robot.geardrop.leftswitchpressed()){
    		Robot.geardrop.openLeftHolder(0.5);
    	}else{
    		Robot.geardrop.pid_moveRightToPosition(2000);
    	}
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

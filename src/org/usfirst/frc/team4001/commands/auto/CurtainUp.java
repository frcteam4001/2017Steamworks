package org.usfirst.frc.team4001.commands.auto;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4001.robot.NumberConstants;
import org.usfirst.frc.team4001.robot.Robot;
/**
 *
 */
public class CurtainUp extends Command {

    public CurtainUp() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.curtain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.curtain.curtainUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//return Robot.geardrop.gearIsInside();
    	return Robot.curtain.get_potValue() > NumberConstants.curtain_max;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.curtain.stopCurtain();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.curtain.stopCurtain();
    }
}

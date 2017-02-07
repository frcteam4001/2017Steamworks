package org.usfirst.frc.team4001.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4001.robot.Robot;
/**
 *
 */
public class TurnRoller extends Command {

    public TurnRoller() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.gearIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gearIntake.turnRoller();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return Robot.geardrop.gearIsInside();
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gearIntake.stopRoller();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

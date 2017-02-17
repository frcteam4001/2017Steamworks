package org.usfirst.frc.team4001.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4001.robot.Robot;
/**
 *
 */
public class TurnRoller extends Command {

    public TurnRoller() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.geardrop);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.geardrop.turnRoller();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.geardrop.gearIsInside();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.geardrop.stopRoller();
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.geardrop.stopRoller();
    }
}

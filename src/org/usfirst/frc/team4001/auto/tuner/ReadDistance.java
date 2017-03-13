package org.usfirst.frc.team4001.auto.tuner;

import org.usfirst.frc.team4001.robot.Robot;

import com.team4001.lib.util.NTInterface;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command reads the distance traveled while it is running from encoders and posts it to 
 * Network Tables on interrupt/end.
 */
public class ReadDistance extends Command {

    public ReadDistance() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.print("The robot traveled " + Double.toString(Robot.drive.getAverageDistance()) + " inches.");
    	Robot.networkTableCom.putNumber(NTInterface.Subsystem.AutoTuner, NTInterface.Key.Distance, Robot.drive.getAverageDistance());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.print("Distance traveled in this path was " + Double.toString(Robot.drive.getAverageDistance()) + " inches.");
    	Robot.networkTableCom.putNumber(NTInterface.Subsystem.AutoTuner, NTInterface.Key.Distance, Robot.drive.getAverageDistance());
    }
}

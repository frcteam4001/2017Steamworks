package org.usfirst.frc.team4001.commands.auto;

import org.usfirst.frc.team4001.robot.NumberConstants;
import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToCamCaptureDistance extends Command {

	private double distance;
	private double speed;
	private double angle;
	private double timeOut;
	private double epsilon;
	
    public DriveToCamCaptureDistance() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.distance = (Robot.drive.getLeftUltrasonicDist() + Robot.drive.getRightUltrasonicDist())/2 - NumberConstants.camera_capture_distance;
		this.speed = 0.5;
		this.angle = 0;
		this.timeOut = 1.5;
		this.epsilon = 0.25;
		Robot.drive.reset();
		setTimeout(timeOut);
    }

 // Called repeatedly when this Command is scheduled to run
 	protected void execute() {
 		Robot.drive.driveStraight(distance, speed, angle, epsilon);
 	}

 	// Command will finish when it is timed out
 	protected boolean isFinished() {
 		return isTimedOut();
 	}

 	// Called once after isFinished returns true, reset all PID controllers and
 	// stop drive.
 	protected void end() {
 		Robot.drive.runLeftDrive(0);
 		Robot.drive.runRightDrive(0);
 		Robot.drive.drivePID.resetPID();
 		Robot.drive.gyroPID.resetPID();
 	}

 	// Called when another command which requires one or more of the same
 	// subsystems is scheduled to run, reset all PID controllers and stop drive.
 	protected void interrupted() {
 		Robot.drive.runLeftDrive(0);
 		Robot.drive.runRightDrive(0);
 		Robot.drive.drivePID.resetPID();
 		Robot.drive.gyroPID.resetPID();
 	}
}

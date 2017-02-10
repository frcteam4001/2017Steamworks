package org.usfirst.frc.team4001.robot.commands;

import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Align extends Command {
	
	private double distance;
	private double speed;
	private double angle;
	private double timeOut;
	private double epsilon;

    public Align() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.distance = 0;
    	this.speed = 0.4;
    	this.angle = Robot.drive.getTurnAngle();
    	this.epsilon = 0.5;
    	this.timeOut = 2;
		Robot.drive.reset();
		setTimeout(timeOut);
	}


    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.driveStraight(distance, speed, angle, epsilon);
    }

    // Make this return true when this Command no longer needs to run execute()
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

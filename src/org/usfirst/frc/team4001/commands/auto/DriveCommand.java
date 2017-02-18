package org.usfirst.frc.team4001.commands.auto;

import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * The Class DriveCommand.
 *
 * @author Bryan Kristiono
 * @since 2016-01-30
 */
public class DriveCommand extends Command {

	// Variables used to store parameter information
	private double distance;
	private double speed;
	private double angle;
	private double timeOut;
	private double epsilon;

	/**
	 * Instantiates a new drive command.
	 *
	 * @param setPoint
	 *            The set point in inches
	 * @param speed
	 *            The speed the robot will move at (0.0 - 1.0)
	 * @param angle
	 *            The angle the robot will travel at in degrees
	 * @param timeOut
	 *            The time out in seconds
	 */
	public DriveCommand(double setPoint, double speed, double angle, double timeOut) {
		this(setPoint, speed, angle, timeOut, 1);
		
	}

	/**
	 * Instantiates a new drive command.
	 *
	 * @param setPoint
	 *            The set point in inches
	 * @param speed
	 *            The speed the robot will move at (0.0 - 1.0)
	 * @param angle
	 *            The angle the robot will travel at in degrees
	 * @param timeOut
	 *            The time out in seconds
	 * @param epsilon
	 *            How close robot should be to target to consider reached
	 */
	public DriveCommand(double setPoint, double speed, double angle, double timeOut, double epsilon) {
		this.distance = setPoint;
		this.speed = speed;
		this.angle = angle;
		this.timeOut = timeOut;
		this.epsilon = epsilon;
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.drive.reset();
		setTimeout(timeOut);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if(Robot.drive.getLeftEncoderDist()>=distance && angle==0){
			Robot.drive.driveStraight(distance, 0, angle, epsilon);
		}
		else {
			Robot.drive.driveStraight(distance, speed, angle, epsilon);
		}
		
		
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

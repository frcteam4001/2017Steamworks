package org.usfirst.frc.team4001.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4001.robot.Robot;
import org.usfirst.frc.team4001.robot.OI;

/**
 *
 */
public class ArcadeDrive extends Command {

    public ArcadeDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double moveForward = Robot.oi.game_controller.getLeftY();
    	double turn = Robot.oi.game_controller.getRightX();
    	
    	
    	if(Robot.oi.drive_slow_button.get()){
    		Robot.drive.arcadeDrive(moveForward*0.5, turn*0.5);
    	}else{
    		Robot.drive.arcadeDrive(moveForward, turn);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.hardStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

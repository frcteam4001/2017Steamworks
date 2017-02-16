package org.usfirst.frc.team4001.robot.commands;

import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbUp extends Command
{

    public ClimbUp()
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.climber);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	if(Robot.climber.state != 1)
    	{
    		Robot.climber.state = 1;
    	}
    	else
    	{
    		Robot.climber.state = 0;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	if(Robot.climber.state == 1)
    	{
    		Robot.climber.expand();
    	}
    	else
    	{
    		Robot.climber.stop();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return Robot.climber.state == 0;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	//Robot.climber.stop();
    	//Robot.climber.state = 0;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    	Robot.climber.stop();
    }
}

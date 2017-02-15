package org.usfirst.frc.team4001.robot.commands;

import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualGearDropLeft extends Command {

    public ManualGearDropLeft()
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//System.out.println("ManualGearDropLeft: constructor() calling");
    	requires(Robot.geardrop);
    	//System.out.println("ManualGearDropLeft: constructor() called");
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	Robot.geardrop.enablePowerMode();
    	if (!Robot.geardrop.get_HoldersPaired()){
    		Robot.geardrop.pairHolders();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	System.out.println("ManualGearDropLeft: command executing");
    	Robot.geardrop.slideleftsync();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
    	System.out.println("ManualGearDropLeft: isFinished() finish detected");
        return Robot.geardrop.leftswitchpressed() || !Robot.geardrop.get_HoldersPaired();
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	System.out.println("ManualGearDropLeft: end()");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    	
    }
}
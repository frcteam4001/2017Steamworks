package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Spark climbMotor;
	
	public Climber() {
		climbMotor = new Spark(ElectricalConstants.CLIMBER_MOTOR);
	}
	
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void expand()
    {
    	climbMotor.set(-0.5);
    }
    
    public void contract()
    {
    	climbMotor.set(1);
    }
    
    public void stop() {
    	climbMotor.set(0);
    }
}

package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;
import org.usfirst.frc.team4001.robot.NumberConstants;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
 
/**
 *
 */
public class Climber extends Subsystem
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Victor climbMotor;
	private int climberState = 0;
	//represents the state of the climber
	//1 means up, 0 means idle, -1 means down

	
	public Climber() {
		climbMotor = new Victor(ElectricalConstants.CLIMBER_MOTOR);
		climbMotor.setInverted(true);

	}
	
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void expand()
    {
    	climbMotor.set(NumberConstants.climber_upSpeed);
    	this.climberState = 1;
    }
    
    public void contract()
    {
    	climbMotor.set(-1*NumberConstants.climber_downSpeed);
    	this.climberState = -1;
    }
    
    public void stop() {
    	climbMotor.set(0);
    	this.climberState = 0;
    }
    
    public int getState()
    {
    	return climberState;
    }
}

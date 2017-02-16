package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;
import org.usfirst.frc.team4001.robot.NumberConstants;

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
	//represents the state of the climber
	//1 means up, 0 means idle, -1 means down
	private int state;
	
	public Climber() {
		climbMotor = new Spark(ElectricalConstants.CLIMBER_MOTOR);
		this.state = 0;
	}
	
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void expand()
    {
    	climbMotor.set(NumberConstants.climber_upSpeed);
    }
    
    public void contract()
    {
    	climbMotor.set(-1*NumberConstants.climber_downSpeed);
    }
    
    public void stop() {
    	climbMotor.set(0);
    }
    
    public void set_state(int new_state){
    	this.state = new_state;
    }
    
    public int get_state(){
    	return this.state;
    }
    
}

package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public CANTalon climbmotor = new CANTalon(ElectricalConstants.CLIMBER_MOTOR);
	
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void expand()
    {
    	climbmotor.set(0.5);
    }
    
    public void contract()
    {
    	climbmotor.set(-0.5);
    }
}

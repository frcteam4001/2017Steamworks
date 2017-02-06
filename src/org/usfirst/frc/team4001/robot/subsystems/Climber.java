package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public PWM climbmotor = new PWM(ElectricalConstants.climber_port);
	
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void expand()
    {
    	climbmotor.setRaw(-1500);
    }
    
    public void contract()
    {
    	climbmotor.setRaw(-500);
    }
}

package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import com.ctre.CANTalon;
/**
 *
 */
public class Curtain extends Subsystem {

	private Spark curtain_motor;
	
	public GearIntake() {
   		curtain_motor = new Spark(ElectricalConstants.GEARDROP_CURTAIN_MOTOR);
	}
	
	public void curtainUp() {
    	curtain_motor.set(0.5);
    }
    
    
    public void stopCurtain() {
    	curtain_motor.set(0);
    }
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Spark;
import com.ctre.CANTalon;
/**
 *
 */
public class Curtain extends Subsystem {

	private Spark curtain_motor;
	private Potentiometer pot;
	private AnalogInput ai;
	double degrees;
	
	public Curtain() {
   		curtain_motor = new Spark(ElectricalConstants.GEARDROP_CURTAIN_MOTOR);
   		ai = new AnalogInput(ElectricalConstants.CURTAIN_POT);
   		pot = new AnalogPotentiometer(ai,360,30);		
	}
	
	
	public void curtainUp() {
    		curtain_motor.set(0.5);
    		degreees = pot.get();
   	}
    
    public void curtainDown() {
    	curtain_motor.set(-0.5);
    	degreees = pot.get();
    }
	
    public void stopCurtain() {
    	curtain_motor.set(0);
    }
    
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

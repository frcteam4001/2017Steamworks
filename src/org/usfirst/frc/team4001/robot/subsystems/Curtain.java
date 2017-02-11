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
	//private AnalogInput ai;
	
	public Curtain() {
   		curtain_motor = new Spark(ElectricalConstants.CURTAIN_MOTOR);
   		pot = new AnalogPotentiometer(ElectricalConstants.CURTAIN_POT,360,30);
   		//ai = new AnalogInput(1);
	}
	
	
	public void curtainUp() {
    		curtain_motor.set(0.5);
    		pot.get();
   	}
    
    public void curtainDown() {
    	curtain_motor.set(-0.5);
    	pot.get();
    }
	
    public void stopCurtain() {
    	curtain_motor.set(0);
    }
    
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

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
   		curtain_motor = new Spark(ElectricalConstants.CURTAIN_MOTOR);
   		curtain_motor.setInverted(true);
   		pot = new AnalogPotentiometer(ElectricalConstants.CURTAIN_POT,360,0);

	}
	
	public void curtainUp() {
    		curtain_motor.set(0.5);
   	}
    
    public void curtainDown() {
    	curtain_motor.set(-0.5);
    }
	
    public void stopCurtain() {
    	curtain_motor.set(0);
    }
    
    public double get_potValue(){
    	return pot.get();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

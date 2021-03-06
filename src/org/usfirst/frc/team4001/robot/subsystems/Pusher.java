package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;

import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pusher extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Solenoid gearPusherOut;
	private Solenoid gearPusherIn;
	private DigitalInput pusher_switch;
	
	public Pusher() {
		
		gearPusherOut = new Solenoid(ElectricalConstants.GEARDROP_PUSHER_OUT);
		gearPusherIn = new Solenoid(ElectricalConstants.GEARDROP_PUSHER_IN);
		pusher_switch = new DigitalInput(ElectricalConstants.PUSHER_SWITCH);
	}
	
	
	
	public boolean pusherIsBack(){
		// boolean return for calibrationSwitch
		return !pusher_switch.get();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void pusherOut() {
    	if (this.pusherIsBack()){
    		gearPusherOut.set(true);
        	gearPusherIn.set(false);
    	}
    	
    }
    
    public void pusherIn() {
    	if (!this.pusherIsBack()){
    		gearPusherOut.set(false);
        	gearPusherIn.set(true);
    	}
    }
    
}


package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearDrop extends Subsystem {
	
	//Define components
	private CANTalon gear_drop_motor_left;
	private CANTalon gear_drop_motor_right;
	private DigitalInput right_switch;
	private DigitalInput left_switch;
	private CANTalon gear_roller;
	
	public double directionCalibration;
	
	public GearDrop(){
   		//Initialize components
   		gear_drop_motor_left = new CANTalon(ElectricalConstants.GEARDROP_MOTOR_LEFT);
   		gear_drop_motor_right = new CANTalon(ElectricalConstants.GEARDROP_MOTOR_RIGHT);
   		right_switch = new DigitalInput(ElectricalConstants.GEARDROP_SWITCH_RIGHT);
   		left_switch = new DigitalInput(ElectricalConstants.GEARDROP_SWITCH_LEFT);
   		gear_roller = new CANTalon(ElectricalConstants.GEARDROP_ROLLER);
   			
   		gear_drop_motor_left.setFeedbackDevice(FeedbackDevice.QuadEncoder);
   		gear_drop_motor_left.configNominalOutputVoltage(+0f, -0f);
   		gear_drop_motor_left.configPeakOutputVoltage(+12f, -12f);    	
   		gear_drop_motor_left.setAllowableClosedLoopErr(0);
   		gear_drop_motor_left.reverseSensor(false);
   	}
	
	public void pid_positionPrep(){
		gear_drop_motor_left.setProfile(0);
		gear_drop_motor_left.setF(0.0);
		gear_drop_motor_left.setP(0.85);
		gear_drop_motor_left.setI(0.0); 
		gear_drop_motor_left.setD(0.3);
		gear_drop_motor_left.changeControlMode(TalonControlMode.Position);
		gear_drop_motor_left.setPosition(0);
	 }
	    
	    public void moveToPosition(int position){
	    	gear_drop_motor_left.set(position);
	    }
	  
	    
	    public Boolean positionReached(){
	    	return gear_drop_motor_left.getClosedLoopError() == 0;
	    }
	  
	    
	    public void openLeftHolder(){
	    	gear_drop_motor_left.set(0.5);
	    }
	    
	    public void openRightHolder(){
	    	gear_drop_motor_right.set(-0.5);
	    }
	    
	    public void stopLeft(){
	    	gear_drop_motor_left.set(0);
	    }
	    
	    
	    public void stopRight(){
	    	gear_drop_motor_right.set(0);
	    }
	
	
	
   	
	public void receive(){
		//If directionCalibration is negative, moves left gear left, otherwise moves right
		if(directionCalibration<0){
			gear_drop_motor_left.reverseOutput(true);
		}
		gear_drop_motor_left.set(1);
	}
	
	public void receive1(){
		// If directionCalibration is positive, moves right gear left, otherwise moves right
		if(directionCalibration<0){
			gear_drop_motor_right.reverseOutput(true);
		}
		gear_drop_motor_right.set(1);
	}
	
	public boolean leftswitchpressed(){
		// boolean return for calibrationSwitch
		return !left_switch.get();
	}
	
	
	public boolean rightswitchpressed(){
		// boolean return for calibrationSwitch
		return !right_switch.get();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }	
}

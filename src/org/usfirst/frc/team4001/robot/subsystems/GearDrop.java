package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;
import org.usfirst.frc.team4001.robot.NumberConstants;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogInput;
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
	//private AnalogInput IRSensor;
	
	public double directionCalibration;
	
	private boolean holderPairing;
	
	public GearDrop(){
   		//Initialize components
   		gear_drop_motor_left = new CANTalon(ElectricalConstants.GEARDROP_MOTOR_LEFT);
   		gear_drop_motor_right = new CANTalon(ElectricalConstants.GEARDROP_MOTOR_RIGHT);
   		right_switch = new DigitalInput(ElectricalConstants.GEARDROP_SWITCH_RIGHT);
   		left_switch = new DigitalInput(ElectricalConstants.GEARDROP_SWITCH_LEFT);
   		gear_roller = new CANTalon(ElectricalConstants.GEARDROP_ROLLER);
   		//IRSensor = new AnalogInput(ElectricalConstants.GEARDROP_IR_SENSOR);
   			
   		gear_drop_motor_left.setFeedbackDevice(FeedbackDevice.QuadEncoder);
   		gear_drop_motor_left.configNominalOutputVoltage(+0f, -0f);
   		gear_drop_motor_left.configPeakOutputVoltage(+12f, -12f);    	
   		gear_drop_motor_left.setAllowableClosedLoopErr(0);
   		
   	}
	

    public void pid_initRightPosition(double p, double i, double d, double f, int closedLoopError, boolean resetEncoder){
    	gear_drop_motor_right.setProfile(0);
		gear_drop_motor_right.setF(f);
		gear_drop_motor_right.setP(p);
		gear_drop_motor_right.setI(i);
		gear_drop_motor_right.setD(d);
		gear_drop_motor_right.changeControlMode(TalonControlMode.Position);
		
		if(resetEncoder && rightswitchpressed() ){
			gear_drop_motor_right.setPosition(0);
		}
		
		gear_drop_motor_right.setAllowableClosedLoopErr(closedLoopError);
    	
    }
    
    
    public boolean get_HoldersPaired(){
    	return this.gear_drop_motor_left.getControlMode() == CANTalon.TalonControlMode.Follower;	
    }
    
    public void pairHolders(){
    	gear_drop_motor_left.changeControlMode(CANTalon.TalonControlMode.Follower);
    	gear_drop_motor_left.set(this.gear_drop_motor_right.getDeviceID());
    }
    
   
    
    public void pid_moveRightToPosition(int position){
    	gear_drop_motor_right.set(position);

    }
  
    
    public Boolean pid_rightPositionReached(){
    	return gear_drop_motor_right.getClosedLoopError() == 0;
    }
  
    
    public void openLeftHolder(double power){
    	gear_drop_motor_left.set(power);
    }
    
    
    public void openRightHolder(double power){
    	gear_drop_motor_right.set(-1*power);
    }
    
    
    public void stopLeftHolder(){
    	gear_drop_motor_left.set(0);
    }
    
    
    public void stopRightHolder(){
    	gear_drop_motor_right.set(0);
    }
    
    
    /* 
	 * Reset the encoder values to 0, used to calibrate
	 */
	public void resetEncoders(){
		// 
		TalonControlMode previous_leftmode = gear_drop_motor_left.getControlMode();
		TalonControlMode previous_rightmode = gear_drop_motor_right.getControlMode();
		
		gear_drop_motor_left.changeControlMode(TalonControlMode.Position);
		gear_drop_motor_left.setPosition(0);
		
		gear_drop_motor_right.changeControlMode(TalonControlMode.Position);
		gear_drop_motor_right.setPosition(0);
		
		gear_drop_motor_left.changeControlMode(previous_leftmode);
		gear_drop_motor_right.changeControlMode(previous_rightmode);

	}
	
	
	/* 
	 * Return encoder position of the left holder motor
	 */
	public int getLeftHolderEncPosition(){
		return gear_drop_motor_left.getEncPosition();
	}
	
	/* 
	 * Return encoder position of the right holder motor 
	 */
	public int getRightHolderEncPosition(){
		return gear_drop_motor_right.getEncPosition();
	}
	
	/* 
	 * Changes gear holder motors to PercentVbus modes
	 */
	public void enablePowerMode(){
		gear_drop_motor_left.changeControlMode(TalonControlMode.PercentVbus);
		gear_drop_motor_right.changeControlMode(TalonControlMode.PercentVbus);
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
    
    /**
     * Reads the IR sensor to determine if a gear is inside the robot
     * @return True if a gear is inside
     */
    
//    public boolean gearIsInside() {
//    	if (IRSensor.getValue() <= NumberConstants.IR_sensor_treshold) {
//    		return true;
//    	} else {
//    		return false;
//    	}
//    }
}

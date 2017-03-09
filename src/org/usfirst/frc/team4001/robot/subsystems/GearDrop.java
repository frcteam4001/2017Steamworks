package org.usfirst.frc.team4001.robot.subsystems;

import org.usfirst.frc.team4001.robot.ElectricalConstants;
import org.usfirst.frc.team4001.robot.NumberConstants;
import org.usfirst.frc.team4001.robot.Robot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
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
	private Solenoid gearPusherOut;
	private Solenoid gearPusherIn;
	
	private AnalogInput IRSensor;
	
	public double directionCalibration;
	
	private boolean closed;
	private int currentZone;
	
	
	public GearDrop(){
   		//Initialize components
   		gear_drop_motor_left = new CANTalon(ElectricalConstants.GEARDROP_MOTOR_LEFT);
   		gear_drop_motor_right = new CANTalon(ElectricalConstants.GEARDROP_MOTOR_RIGHT);
   		right_switch = new DigitalInput(ElectricalConstants.GEARDROP_SWITCH_RIGHT);
   		left_switch = new DigitalInput(ElectricalConstants.GEARDROP_SWITCH_LEFT);

		gear_roller = new CANTalon(ElectricalConstants.GEARDROP_ROLLER);
   		IRSensor = new AnalogInput(ElectricalConstants.GEARDROP_IR_SENSOR);
   		//gearPusherOut = new Solenoid(ElectricalConstants.GEARDROP_PUSHER_OUT);
   		//gearPusherIn = new Solenoid(ElectricalConstants.GEARDROP_PUSHER_IN);

   		gear_drop_motor_right.setFeedbackDevice(FeedbackDevice.QuadEncoder);
   		gear_drop_motor_right.configNominalOutputVoltage(+0f, -0f);
   		gear_drop_motor_right.configPeakOutputVoltage(+3f, -3f);    	
   		
   		this.closed = true;
   		gear_drop_motor_left.changeControlMode(CANTalon.TalonControlMode.Follower);
    	gear_drop_motor_left.set(this.gear_drop_motor_right.getDeviceID());
    	this.pid_initRightPosition(NumberConstants.geardrop_holder_close_p, NumberConstants.geardrop_holder_close_i, NumberConstants.geardrop_holder_close_d, NumberConstants.geardrop_holder_close_f, NumberConstants.geardrop_holder_close_error, false, NumberConstants.geardrop_slide_peakvolage);
   		this.currentZone = 1;
   		
   	}
	
	public boolean get_closed (){
		return this.closed;
	}
	
	public void set_closed(boolean state){
		this.closed = state;
	}
	
	
    public void pid_initRightPosition(double p, double i, double d, double f, int closedLoopError, boolean resetEncoder, double peak_voltage){
    	gear_drop_motor_right.setProfile(0);
		gear_drop_motor_right.setF(f);
		gear_drop_motor_right.setP(p);
		gear_drop_motor_right.setI(i);
		gear_drop_motor_right.setD(d);
		gear_drop_motor_right.configNominalOutputVoltage(+0f, -0f);
   		gear_drop_motor_right.configPeakOutputVoltage(peak_voltage, -1*peak_voltage);   
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
    	gear_drop_motor_right.changeControlMode(TalonControlMode.Position);
    	gear_drop_motor_right.set(position);
    }
  
    
    public Boolean pid_rightPositionReached(){
    	return Math.abs(gear_drop_motor_right.getClosedLoopError()) < NumberConstants.geardrop_holder_close_error;
    }
  
    
    public void openLeftHolder(double power){
    	gear_drop_motor_left.set(power);
    }
    
    
    public void openRightHolder(double power)
    {
	this.unpairmotors();
    	gear_drop_motor_right.set(-1*power);
    }
    
    
    /**
     * Stop the 
     */
    public void stopLeftHolder()
    {
	//this.unpairmotors();
    	gear_drop_motor_left.set(0);
    }
    
    /**
     * Stop the right holder
     */
    public void stopRightHolder(){
    	gear_drop_motor_right.set(0);
    }
    
    
    /** 
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
	
	
	/* *
	 * Return encoder position of the left holder motor
	 */
	public int getLeftHolderEncPosition(){
		return gear_drop_motor_left.getEncPosition();
	}
	
	/* *
	 * Return encoder position of the right holder motor 
	 */
	public int getRightHolderEncPosition(){
		return gear_drop_motor_right.getEncPosition();
	}
	
	/* *
	 * Changes gear holder motors to PercentVbus modes
	 */
	public void enablePowerMode(){
		gear_drop_motor_left.changeControlMode(TalonControlMode.PercentVbus);
		gear_drop_motor_right.changeControlMode(TalonControlMode.PercentVbus);
	}
	
 
	/**
	 * Check if the left switch is pressed
	 */
	public boolean leftswitchpressed(){
		// boolean return for calibrationSwitch
		return !left_switch.get();
	}
	
	public boolean get_HoldersOpened(){
		return this.leftswitchpressed() && this.rightswitchpressed();
	}
	
	/**
	 * Check if the right switch is pressed	
	 * @return True if the right switch is pressed
	 */
	public boolean rightswitchpressed(){
		// boolean return for calibrationSwitch
		return !right_switch.get();
	}

	/**
	 * Move the gear feed roller
	 */
	public void turnRoller() {
    		gear_roller.set(-0.8);
    	}
   
	/**
	 * Stop the gear feed roller
	 */
   	public void stopRoller() {
    		gear_roller.set(0);
    	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	/*
	 * Take the left gear motor out of follower mode and set to power mode
	 */
    public void unpairmotors()
    {
    	this.gear_drop_motor_left.set(0);	
    	this.gear_drop_motor_left.changeControlMode(TalonControlMode.PercentVbus);
    }
    
    
    /**
     * get the current zone position
     */
    public int getCurrentZone(){
    	return this.currentZone;
    }
    
    /**
     * slide to a specific zone
     * @param setZone - the zone to slide to
     */
    public void slideToZone(int setZone){
    	int setPosition;
    	
    	if(this.get_HoldersPaired()){
    		setPosition = NumberConstants.geardrop_start - NumberConstants.geardrop_zone_interval*(setZone-1);
    		this.pid_moveRightToPosition(setPosition);
    		this.currentZone = setZone;
    		
    	}
    }
    
    /**
     * Slide the gear holders to the home paired position
     */
    public void slideHome(){
    	this.slideToZone(1);
    }
    
    
    /**
     * Slide holders one zone left 
     */
    public void slideZoneLeft()
    {
    	if(this.currentZone > 1){
    		if(this.get_HoldersPaired())
        	{
        		this.slideToZone(this.currentZone - 1);	
        	}	
    	}   	
    }
    
    /**
     * Slide holders one zone right
     */
    public void slideZoneRight()
    {
    	if(this.currentZone < NumberConstants.geardrop_number_of_zones){
    		if(this.get_HoldersPaired())
        	{
        		this.slideToZone(this.currentZone + 1);
        	}	
    	}  
    }
    
    public void resetCurrentZone_value(int setZone){
    	this.currentZone = setZone;
    }
    
    /**
     * Reads the IR sensor to determine if a gear is inside the robot
     * @return True if a gear is inside
     */
    
    public boolean gearIsInside() {
    	if (IRSensor.getValue() > NumberConstants.IR_sensor_treshold) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * Get IR sensor value
     * @return the raw value of the sensor
     */
    public double getIR() {
    	return IRSensor.getValue();
    }
    
    public void pusherOut() {
    	gearPusherOut.set(true);
    	gearPusherIn.set(false);
    }
    
    public void pusherIn() {
    	gearPusherOut.set(false);
    	gearPusherIn.set(true);
    }
    
}

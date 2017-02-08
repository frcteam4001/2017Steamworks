package org.usfirst.frc.team4001.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4001.robot.ElectricalConstants;

import com.ctre.*;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 */
public class GearDrop_temp extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final CANTalon gear_holder_left = new CANTalon(ElectricalConstants.GEARDROP_MOTOR_LEFT);
	private final CANTalon gear_holder_right = new CANTalon(ElectricalConstants.GEARDROP_MOTOR_RIGHT);
	private final CANTalon gear_roller = new CANTalon(ElectricalConstants.GEARDROP_ROLLER);
	
	private final DigitalInput switch_left = new DigitalInput(ElectricalConstants.GEARDROP_SWITCH_LEFT);
	private final DigitalInput switch_right = new DigitalInput(ElectricalConstants.GEARDROP_SWITCH_RIGHT);
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public GearDrop_temp(){
    	gear_holder_right.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	gear_holder_right.configNominalOutputVoltage(+0f, -0f);
    	gear_holder_right.configPeakOutputVoltage(+12f, -12f);    	
    	gear_holder_right.setAllowableClosedLoopErr(100);
    	gear_holder_right.reverseSensor(true);

    	
    }
    
    public void pid_positionPrep(){
    	gear_holder_right.changeControlMode(TalonControlMode.Position);
    	gear_holder_right.setPosition(0);
    }
    
    public void moveToPosition(int position){
    	gear_holder_right.set(position);
    }
    
    public Boolean positionReached(){
    	return gear_holder_right.getClosedLoopError() == 0;
    }
    
}


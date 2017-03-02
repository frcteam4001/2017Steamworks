package org.usfirst.frc.team4001.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pusher extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private DoubleSolenoid gear_sol;
	private DigitalInput pusher_switch;
	
	public void Pusher() {
		gear_sol = new DoubeSolenoid(ElectricalConstants.GEARDROP_PUSHER_OUT, ElectricalConstants.GEARDROP_PUSHER_IN)
		
	}
	
	public void forwardSol() {
		gear_sol.set(DoubleSolenoid.Value.kForward);
		
	}
	
	public void reverseSol() {
		gear_sol.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void stopSol() {
		gear_sol.set(DoubleSolenoid.Value.kOff);
	}
	
	public boolean pusherPressed(){
		// boolean return for calibrationSwitch
		return !pusher_switch.get();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


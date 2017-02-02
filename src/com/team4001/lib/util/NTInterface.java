package com.team4001.lib.util;


import edu.wpi.first.wpilibj.networktables.*;


public class NTInterface {
	
	public enum Subsystem {
		DriveTrain, GearDrop, GearZone
	}
	
	public enum Key {
		//GearDrop valid keys
		RightGearMotorPosition("Right Gear Motor Position"),
		LeftGearMotorPosition("Left Gear Motor Position"),
		
		//DriveTrain valid keys
		LeftDriveEncoder("Left Drive Encoder"),
		RightDriveEncoder("Right Drive Encoder"),
		GyroAngle("Gyro Angle"),
		LeftUltrasonicDistance("Left Ultrasonic Distance"), 
		RightUltrasonicDistance("Right Ultrasonic Distance"),
		
		//GearZone valid keys
		GearZone("zone")
		;
		
		
		private final String text;

	    /**
	     * @param text
	     */
	    private Key(final String text) {
	        this.text = text;
	    }

	    /* (non-Javadoc)
	     * @see java.lang.Enum#toString()
	     */
	    @Override
	    public String toString() {
	        return text;
	    }
	}
	
	
	//Declare all the tables
	NetworkTable driveTrain;
	NetworkTable gearDrop;
	
	public NTInterface() {
		//Initialize the connection
		NetworkTable.setServerMode();
		NetworkTable.setTeam(4001);
		NetworkTable.initialize();
		
		//Initialize the tables
		driveTrain = NetworkTable.getTable("DriveTrain");
	}
	
	/**
	Publishes a number to a key on a table.
	@param subsystem
		the name of the subsystem which would be the the name of the table
	@param key
		the label of the value being posted
	@param value
		the double value to be posted
	**/
	public void putNumber(Subsystem subsystem, Key key, Double value) {
		switch(subsystem) {
			case DriveTrain:
				driveTrain.putNumber(key.toString(), value);
				break;
			case GearDrop:
				gearDrop.putNumber(key.toString(), value);
				break;
		}
	}
	
	/**
	Publishes a boolean to a key on a table.
	@param subsystem
		the name of the subsystem which would be the the name of the table
	@param key
		the label of the value being posted
	@param value
		the boolean value to be posted
	**/
	public void putBoolean(Subsystem subsystem, Key key, boolean value) {
		switch(subsystem) {
		case DriveTrain:
			driveTrain.putBoolean(key.toString(), value);
			break;
		case GearDrop:
			gearDrop.putBoolean(key.toString(), value);
			break;
		}
	}
	
	/**
	Returns a number from a key on a table.
	@param subsystem
		the name of the subsystem which would be the the name of the table
	@param key
		the label of the value being fetched
	@return double, -20000 indicates there was no value at the requested key on the table, -30000 indicates the table wasn't found
	**/
	public double getNumber(Subsystem subsystem, Key key) {
		switch(subsystem) {
			case DriveTrain:
				return driveTrain.getNumber(key.toString(), -20000);
			case GearDrop:
				return gearDrop.getNumber(key.toString(), -20000);
		}
		return -30000;
	}
	
	/**
	Returns a boolean from a key on a table.
	@param subsystem
		the name of the subsystem which would be the the name of the table
	@param key
		the label of the value being fetched
	@return boolean, returns false if the key/table were not found
	**/
	public boolean getBoolean(Subsystem subsystem, Key key) {
		switch(subsystem) {
			case DriveTrain:
				return driveTrain.getBoolean(key.toString(), false);
			case GearDrop:
				return gearDrop.getBoolean(key.toString(), false);
		}
		return false;
	}
	
	
	
}

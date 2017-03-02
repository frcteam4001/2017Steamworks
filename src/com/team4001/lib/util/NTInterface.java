package com.team4001.lib.util;


import java.util.Set;

import edu.wpi.first.wpilibj.networktables.*;


public class NTInterface {
	
	public enum Subsystem {
		DriveTrain, GearDrop, GearZone, Curtain, Climber
	}
	
	public enum Key {
		//GearDrop valid keys
		RightGearMotorPosition("Right Gear Motor Position"),
		LeftGearMotorPosition("Left Gear Motor Position"),
		GearOpen("Gear Open"),
		GearInside("Gear Inside"),
		
		//DriveTrain valid keys
		LeftDriveEncoder("Left Drive Encoder"),
		RightDriveEncoder("Right Drive Encoder"),
		GyroAngle("Gyro Angle"),
		LeftUltrasonicDistance("Left Ultrasonic Distance"), 
		RightUltrasonicDistance("Right Ultrasonic Distance"),
		
		//GearZone valid keys
		TargetZone("zone"),
		CurrentZone("Current Zone"),
		IRreadingL("IRreadingL"),
		IRreadingR("IRreadingR"),
		Encoder("Encoder"),
		
		//Curtain keys
		CurtainUp("Curtain Up"),
		
		//Climber keys
		ClimberState("Climb Status")
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
	NetworkTable GearZone;
	NetworkTable climber;
	NetworkTable curtain;
	
	public NTInterface() {
		//Initialize the connection
		NetworkTable.setServerMode();
		NetworkTable.setTeam(4001);
		NetworkTable.initialize();
		
		//Wait for connection (is it needed? I don't know :|)
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Initialize the tables
		driveTrain = NetworkTable.getTable("DriveTrain");
		gearDrop = NetworkTable.getTable("GearDrop");
		GearZone = NetworkTable.getTable("GearZone");
		climber = NetworkTable.getTable("Climber");
		curtain = NetworkTable.getTable("Curtain");
		
	}
	
	/**
	Publishes a number to a key on a table. To use this method, import NTInterface.Key and
	NTInterface.Subsystem and pass the parameters in the form of "Subsystem.Foo" and "Key.Foo".
	WARNING: This method does NOT check if the key is from the correct subsystem!
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
			case Climber:
				climber.putNumber(key.toString(), value);
			case Curtain:
				curtain.putNumber(key.toString(), value);
		}
	}
	
	/**
	Publishes a boolean to a key on a table. To use this method, import NTInterface.Key and
	NTInterface.Subsystem and pass the parameters in the form of "Subsystem.Foo" and "Key.Foo".
	WARNING: This method does NOT check if the key is from the correct subsystem!
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
		case Climber:
			climber.putBoolean(key.toString(), value);
			break;
		case Curtain:
			curtain.putBoolean(key.toString(), value);
			break;
		}
	}
	
	/**
	Returns a number from a key on a table. To use this method, import NTInterface.Key and
	NTInterface.Subsystem and pass the parameters in the form of "Subsystem.Foo" and "Key.Foo".
	WARNING: This method does NOT check if the key is from the correct subsystem!
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
			case GearZone:
				return GearZone.getNumber(key.toString(), -20000);
			case Climber:
				return climber.getNumber(key.toString(), -20000);
			case Curtain:
				return curtain.getNumber(key.toString(), -20000);
		}
		return -30000;
	}
	
	/**
	Returns a boolean from a key on a table. To use this method, import NTInterface.Key and
	NTInterface.Subsystem and pass the parameters in the form of "Subsystem.Foo" and "Key.Foo".
	WARNING: This method does NOT check if the key is from the correct subsystem!
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
			case GearZone:
				return GearZone.getBoolean(key.toString(), false);
			case Climber:
				return climber.getBoolean(key.toString(), false);
			case Curtain:
				return curtain.getBoolean(key.toString(), false);
		}
		return false;
	}
	
	//resets all the networkTables
	public void reset()
	{
		Set<String> driveTrainKeys = this.driveTrain.getKeys();
		for(String s : driveTrainKeys)
		{
			this.driveTrain.putBoolean(s, false);
			this.driveTrain.putNumber(s, 0);
		}
			
		Set<String> gearDropKeys = this.gearDrop.getKeys();
		for(String s : gearDropKeys)
		{
			this.gearDrop.putBoolean(s, false);
			this.gearDrop.putNumber(s, 0);
		}
			
		Set<String> gearZoneKeys = this.GearZone.getKeys();
		for(String s : gearZoneKeys)
		{
			this.GearZone.putBoolean(s, false);
			this.GearZone.putNumber(s, 0);
		}
	}
	
}

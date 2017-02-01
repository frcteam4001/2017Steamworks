package com.team4001.lib.util;


import edu.wpi.first.wpilibj.networktables.*;


public class NTInterface {
	
	
	//Declare all the tables
	NetworkTable driveTrain;
	
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
	public void putNumber(String subsystem, String key, Double value) {
		switch(subsystem) {
			case "DriveTrain":
				driveTrain.putNumber(key, value);
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
	public void putBoolean(String subsystem, String key, boolean value) {
		switch(subsystem) {
			case "DriveTrain":
				driveTrain.putBoolean(key, value);
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
	public double getNumber(String subsystem, String key) {
		switch(subsystem) {
			case "DriveTrain":
				return driveTrain.getNumber(key, -20000);
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
	public boolean getBoolean(String subsystem, String key) {
		switch(subsystem) {
			case "DriveTrain":
				return driveTrain.getBoolean(key, false);
		}
		return false;
	}
	
	
	
}

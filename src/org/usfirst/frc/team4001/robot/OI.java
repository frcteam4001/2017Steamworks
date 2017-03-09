package org.usfirst.frc.team4001.robot;

import edu.wpi.first.wpilibj.buttons.Button;

import org.usfirst.frc.team4001.commands.auto.GearPusher;
import org.usfirst.frc.team4001.robot.commands.*;


import com.team4001.lib.util.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	

	


	//PRIMARY CONTROLLER
	public Gamepad game_controller;
	public JoystickButton gearslideRight_button;
	public JoystickButton gearslideLeft_button;
	public JoystickButton drive_slow_button;
	
	public JoystickButton place_gear_button;
	public JoystickButton get_gear_button;
	
	public JoystickButton gear_open_button;
	public JoystickButton gear_close_button;
	public AxisButton pusher_trigger;

	//SUPPORT CONTROLLER	
	public Gamepad support_controller;
	JoystickButton climb_up;
	JoystickButton climb_down;

	
	public OI(){


		game_controller = new Gamepad(0);
		support_controller = new Gamepad(1);
		
        /*********************************
         * PRIMARY CONTROLLER
         ********************************/
		
		//PRIMARY CONTROL - RIGHT SHOULDER
		//place_gear_button = game_controller.getRightShoulder();
        //place_gear_button.whenPressed(new PlaceGearNoForward());
        
        drive_slow_button = game_controller.getLeftShoulder();
        
        pusher_trigger = game_controller.getRightAxisButton();
        pusher_trigger.whenPressed(new GearPusher());
        
        
       
        
        
        
        /*********************************
         * SUPPORT CONTROLLER
         ********************************/
        
        //SUPPORT CONTROL - Y
        //change button binding configuration later
        climb_up = support_controller.getButtonY();
        //climb_down = support_controller.getButtonX();
      		
        climb_up.toggleWhenPressed(new ClimbUp());
        //climb_down.toggleWhenPressed(new ClimbDown());
        
        //SUPPORT CONTROL - X
        get_gear_button = support_controller.getButtonX();
        get_gear_button.whenPressed(new GetGearNoAlign());
        
        
        
        
        //SUPPORT CONTROL - B
        gear_open_button = support_controller.getButtonB();
        gear_open_button.whenPressed(new GearHoldersFullOpen());
        
        //SUPPORT CONTROL -A
        gear_close_button = support_controller.getButtonA();
        gear_close_button.whenPressed(new GearCloseHolders());
        
        //RIGHT SHOULDER - Manual Slide Right
        gearslideRight_button = support_controller.getRightShoulder();
		gearslideRight_button.whenPressed(new GearSlidetoZoneManualRight());
		
		
		//LEFT SHOULDER - Manual Slide Left
		gearslideLeft_button = support_controller.getLeftShoulder();
        gearslideLeft_button.whenPressed(new GearSlidetoZoneManualLeft());
        
        
        //climb_up.cancelWhenPressed(up_command);
        //climb_down.cancelWhenPressed(down_command);

		
		

		
		
		
		
        //support_controller.getRightShoulder().whileHeld();
        //support_controller.getRightAxisButton().whileHeld();
		
        
        
        
	}
}

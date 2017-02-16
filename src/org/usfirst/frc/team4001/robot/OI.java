package org.usfirst.frc.team4001.robot;

import edu.wpi.first.wpilibj.buttons.Button;
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
	

	public Gamepad game_controller;
	public Gamepad support_controller;

	public Button goForward;
	
	public JoystickButton gearslideRight;
	public JoystickButton gearslideLeft;
	
	//button for climbing command
	JoystickButton climb_up;
	JoystickButton climb_down;
	JoystickButton place_gear;
	JoystickButton get_gear;
	
	ClimbUp up_command = new ClimbUp();
	ClimbDown down_command = new ClimbDown();
	
	public OI(){


		game_controller = new Gamepad(0);
		support_controller = new Gamepad(1);
		
		//game controller - primary control
		place_gear = game_controller.getButtonX();
        place_gear.whenPressed(new PlaceGear());
        
        get_gear = game_controller.getButtonY();
        get_gear.whenPressed(new GetGearAutoAlign());
        
        
        
        //SUPPORT CONTROLLER
        //change button binding configuration later
        climb_up = support_controller.getButtonY();
        climb_down = support_controller.getButtonX();
      		
        climb_up.whenPressed(new ClimbUp());
        climb_down.whenPressed(new ClimbDown());
        
        //climb_up.cancelWhenPressed(up_command);
        //climb_down.cancelWhenPressed(down_command);

		
		//gearslideRight = game_controller.getRightShoulder();
		//gearslideRight.whileHeld(new ManualGearDropRight());
		
		//gearslideLeft = game_controller.getLeftShoulder();
        //gearslideLeft.whileHeld(new ManualGearDropLeft());

		
		
		
		
        //support_controller.getRightShoulder().whileHeld();
        //support_controller.getRightAxisButton().whileHeld();
		
        
        
        
	}
}

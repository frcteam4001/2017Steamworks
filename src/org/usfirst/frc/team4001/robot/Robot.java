
package org.usfirst.frc.team4001.robot;


//import edu.wpi.cscore.CvSink;
//import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


//import com.team4001.lib.util.NTInterface;
//import com.team4001.lib.util.NTInterface.Subsystem;
//import com.team4001.lib.util.NTInterface.Key;
//
//
//import org.opencv.core.Mat;
//import org.opencv.core.Point;
//import org.opencv.core.Scalar;
//import org.opencv.imgproc.Imgproc;

import org.usfirst.frc.team4001.commands.auto.*;


import org.usfirst.frc.team4001.robot.commands.*;
import org.usfirst.frc.team4001.robot.subsystems.*;

import com.team4001.lib.util.NTInterface;
import com.team4001.lib.util.NTInterface.Key;
import com.team4001.lib.util.NTInterface.Subsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;

	Command autonomousCommand;
	
	SendableChooser<Command> autoChooser;
	
	public static DriveTrain drive;
	public static GearDrop geardrop;
	public static Climber climber;
	public static Curtain curtain;
	public static NTInterface networkTableCom;
	public static double gearZone;
	public static double rightir;
	public static double leftir;
	public static double avgdistance;
	public static CameraServer server;
	
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		drive = new DriveTrain();
		geardrop = new GearDrop();

		climber = new Climber();
		curtain = new Curtain();
		oi = new OI();


		networkTableCom = new NTInterface();
		//networkTableCom.reset();
		//AUTONOMOUS CHOOSER COMMANDS
		// chooser.addObject("My Auto", new MyAutoCommand());
		autoChooser = new SendableChooser<Command>();
		autoChooser.addDefault("Default: Drive Straight and Stop", new DriveCommand(58.36, 0.5, 0, 8, 0.2));
		autoChooser.addObject("Blue Right with Gear", new DriveKeyLineAndGear(1));
		autoChooser.addObject("Red Left with Gear", new DriveKeyLineAndGear(-1));
		autoChooser.addObject("Blue Left with Gear", new DriveRetLineAndGear(1));
		autoChooser.addObject("Red Right with Gear", new DriveRetLineAndGear(-1));
		SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);

		

		//SmartDashboard.putData("Open Left Gear Holder", new GearHolderLeftFullOpen());
		//SmartDashboard.putData("Open Right Gear Holder", new GearHolderRightFullOpen());
		SmartDashboard.putData("Open Holders", new GearHoldersFullOpen());
		SmartDashboard.putData("Close Holders", new GearCloseHolders());
		SmartDashboard.putData("ResetEncoders", new GearDrop_ResetEncoders());
		SmartDashboard.putData("Drive to CCD", new DriveToCamCaptureDistance());

		SmartDashboard.putData("Climber contract", new ClimbUp());
		SmartDashboard.putData("curtain up", new CurtainUp());
		SmartDashboard.putData("curtain down", new CurtainDown());

		SmartDashboard.putData("align", new Align());

		SmartDashboard.putData("Slide To Zone", new GearSlidetoZone());
		SmartDashboard.putData("Get Gear - No Align", new GetGearNoAlign());
		SmartDashboard.putData("Get Gear with Align", new GetGearAutoAlign());
		SmartDashboard.putData("Place Gear", new PlaceGear());
		SmartDashboard.putData(Scheduler.getInstance());
		

	    
	    // Get the UsbCamera from CameraServer
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture("cam1",1);
		
		// Set the resolution
		camera.setResolution(320, 240);
		
		

	}
 
	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		//autonomousCommand = chooser.getSelected();
		//String autoSelected = SmartDashboard.getString("Auto Selector");
		autonomousCommand = (Command) autoChooser.getSelected();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 
		switch(autoSelected){
		
		case "Drive Straight and Stop":
			autonomousCommand = new DriveCommand(58.36, 0.5, 0, 8, 0.2);
			break;
		case "Drive Red Right to Gear":
			autonomousCommand = new DriveRedRightToGear();
			break;
		case "Drive Left Red to Gear":
			autonomousCommand = new DriveRedLeftToGear();
			break;
		default: 
			autonomousCommand = new DriveCommand(58.36, 0.5, 0, 1.5, 0.2);
			break;
			
		}
		*/
		//autonomousCommand = new DriveCommand(58.36, 0.5, 0, 1.5, 0.2);
//		autonomousCommand = new Test90DegPlace();

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		SmartDashboard.putNumber("Left Drive Encoder", drive.getLeftEncoderDist());
		SmartDashboard.putNumber("Right Drive Encoder", drive.getRightEncoderDist());
		Scheduler.getInstance().run();
		
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		SmartDashboard.putNumber("Right Gear Motor Position", geardrop.getRightHolderEncPosition());
		SmartDashboard.putNumber("Left Gear Motor Position", geardrop.getLeftHolderEncPosition());
		SmartDashboard.putBoolean("Left Switch", geardrop.leftswitchpressed());
		SmartDashboard.putBoolean("Right Switch", geardrop.rightswitchpressed());
		SmartDashboard.putBoolean("Holders Paired", geardrop.get_HoldersPaired());
		SmartDashboard.putNumber("Left Drive Encoder", drive.getLeftEncoderDist());
		SmartDashboard.putNumber("Right Drive Encoder", drive.getRightEncoderDist());
		SmartDashboard.putNumber("Gyro Angle", drive.getYaw());
		SmartDashboard.putNumber("IR READING", geardrop.getIR());
		SmartDashboard.putNumber("Left IR", drive.getLeftUltrasonicDist());
		SmartDashboard.putNumber("Right IR", drive.getRightUltrasonicDist());
		SmartDashboard.putNumber("raw left IR", drive.getRawIRLeft());
		SmartDashboard.putNumber("raw IR right", drive.getRawIRRight());
		SmartDashboard.putNumber("Curtain Pot", curtain.get_potValue());

//		networkTableCom.putNumber(Subsystem.DriveTrain, Key.RightDriveEncoder, drive.getRightEncoderDist());
//		networkTableCom.putNumber(Subsystem.DriveTrain, Key.LeftDriveEncoder, drive.getLeftEncoderDist());
//		networkTableCom.putNumber(Subsystem.DriveTrain, Key.GyroAngle, drive.getYaw());
//				
//		networkTableCom.putNumber(Subsystem.GearDrop, Key.RightGearMotorPosition, geardrop.getRightHolderEncPosition()/1.0);
//		networkTableCom.putNumber(Subsystem.GearDrop, Key.LeftGearMotorPosition, geardrop.getLeftHolderEncPosition()/1.0);

		gearZone = networkTableCom.getNumber(Subsystem.GearZone, Key.GearZone);
		networkTableCom.putNumber(Subsystem.GearZone, Key.GearZone, gearZone);
		
		SmartDashboard.putNumber("GearZone",gearZone);
		
		avgdistance = drive.getAverageDistance();
    	leftir = drive.getRawIRLeft();
    	rightir = drive.getRawIRRight();
    	
    	networkTableCom.putNumber(Subsystem.DriveTrain, Key.IRreadingL, leftir);
    	networkTableCom.putNumber(Subsystem.DriveTrain, Key.IRreadingR, rightir);
    	networkTableCom.putNumber(Subsystem.DriveTrain, Key.Encoder, avgdistance);
		

		//System.out.println("gear zone: " + Double.toString(gearZone));
		
		
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}

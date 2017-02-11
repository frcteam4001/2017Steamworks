package org.usfirst.frc.team4001.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4001.robot.Robot;
import org.usfirst.frc.team4001.commands.auto.DriveCommand;
import org.usfirst.frc.team4001.robot.NumberConstants;

/**
 *This is THE command group for placing the gear. It pulls together all other commands to handle
 *the entire process, from start to finish. This should be the only command that is mapped to 
 *the controller for the purpose of placing the gear. 
 */
public class PlaceGear extends CommandGroup {

    public PlaceGear() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
//    	//Level to airship
//    	addSequential(new Align());
//    	
//    	//Drive to camera_capture_distance from the airship. The average of the readings from the
//    	//ultrasonic sensors is used to increase accuracy
//    	double distanceFromAirship = (Robot.drive.getLeftUltrasonicDist() + Robot.drive.getRightUltrasonicDist()) / 2.0;
//    	double distanceToTravel = distanceFromAirship - NumberConstants.camera_capture_distance;
//    	addSequential(new DriveCommand(distanceToTravel, 0.5, 0, 5));
//    	
//    	
    	addSequential(new Align());
    	addSequential(new DriveToCamCaptureDistance());
    	
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	addSequential(new DriveCommand(NumberConstants.camera_capture_distance - 13, 0.5, 0, 2, 0.3));
    	
    }
}

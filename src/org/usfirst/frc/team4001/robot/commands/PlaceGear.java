package org.usfirst.frc.team4001.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4001.robot.Robot;
import org.usfirst.frc.team4001.commands.auto.DriveCommand;
import org.usfirst.frc.team4001.commands.auto.DriveToCamCaptureDistance;
import org.usfirst.frc.team4001.commands.auto.GearPusherAuto;
import org.usfirst.frc.team4001.commands.auto.PusherAutoCommand;
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
    	

    	
    	//addSequential(new Align());
    	
    	
    	addParallel(new GearSlideToHomeZone());
    	//addSequential(new DriveToCamCaptureDistance());
    	
    	try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if (Robot.gearZone != -1 && Robot.gearZone != -20000 && Robot.gearZone != -30000){
    		addSequential(new GearSlidetoVisionZone());
 
    		addSequential(new DriveCommand(NumberConstants.camera_capture_distance - 8, 0.35, 0, 1.5, 0.3));
    		addSequential(new GearPusherAuto());
    	} else if (Robot.gearZone == -1) {
    		addSequential(new DriveCommand(12, 0.5, 0, 1.5, 0.3));
    	}
    	
    	
    }
}

package org.usfirst.frc.team4001.commands.auto;

import org.usfirst.frc.team4001.robot.commands.GearHoldersFullOpen;
import org.usfirst.frc.team4001.robot.commands.PlaceGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MidDriveAndGear extends CommandGroup {
	
	public int n; 

    public MidDriveAndGear() {
    	
    	
    	
    	// initial drive forward
    	//addSequential(new DriveCommand(54.36, 0.5, 0, 3, 0.2));
    	 
    	addSequential(new DriveCommand(66, 0.6, 0, 3.5, 0.2));
    	addSequential(new GearHoldersFullOpen());
    	addSequential(new GearPusherAuto());
    	addSequential(new DriveCommand(-12, 0.3, 0, 1, 0.2));
    	
    	// place the gear starting at capture distance
    	//addSequential(new PlaceGear());
    	
    	//addSequential(new DriveCommand(-36, 0.5, 0, 2, 0.2));
    	
    	
    	//addSequential(new DriveCommand(-32, 0.6, 0, 2, 0.2));
    	//addSequential(new DriveCommand(0, 0.6, 40*n, 1, 0.2));
    	//addSequential(new DriveCommand(140, 0.6, 0 , 5, 0.2));
    	System.out.println("done");
    	
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
    }
}

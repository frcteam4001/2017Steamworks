package org.usfirst.frc.team4001.commands.auto;

import org.usfirst.frc.team4001.robot.commands.GearHoldersFullOpen;
import org.usfirst.frc.team4001.robot.commands.PlaceGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveAndGear extends CommandGroup {
	
	public int n;

    public DriveAndGear(int n) {
    	
    	
    	this.n = n;

    	if(n == 1){ //Red Mid

        	addSequential(new DriveCommand(68.57 * 1.03, 0.4, 0, 3, 0.2)); 

        	addSequential(new GearHoldersFullOpen());
        	
        	addSequential(new GearPusherOut());
        	
        	addSequential(new DriveCommand(-24, 0.35,0, 1.5, 0.2));
        	addSequential(new GearPusherIn());

    	}
    	else if(n == 2){ //Blue Mid
    		
        	addSequential(new DriveCommand(68.5 * 1.03, 0.4, 0, 3, 0.2));

        	addSequential(new GearHoldersFullOpen());
        	
        	addSequential(new GearPusherOut());
        	
        	addSequential(new DriveCommand(-24, 0.35,0, 1.5, 0.2));
        	addSequential(new GearPusherIn());

    	}
    	else if (n == 3 ) { //Red Boiler
    		addSequential(new DriveCommand(79.61 *1.03, 0.4, 0, 2.75, 0.2));
    		addSequential(new DriveCommand(0, 0.3, -43.45 * 0.96, 1, 0.2));
    		addSequential(new DriveCommand(20 * 1.03, 0.4, 0, 1, 0.2));
    	}
    	else if (n == 4) { //Blue Boiler
    		addSequential(new DriveCommand(80.67 *1.03, 0.4, 0, 2.75, 0.2));
    		addSequential(new DriveCommand(0, 0.3, 63.26 * 0.96, 1.25, 0.2));
    		addSequential(new DriveCommand(24 * 1.03, 0.4, 0, 1, 0.2));
    	}
    	else if (n == 5) { //Red Loading station
    		addSequential(new DriveCommand(75.12 *1.03, 0.4, 0, 2.75, 0.2));
    		addSequential(new DriveCommand(0, 0.3, 55.57 * 0.96, 1.25, 0.2));
    		addSequential(new DriveCommand(37.06 * 1.03, 0.4, 0, 1.5, 0.2));
    	}
    	else if (n == 6) { //Blue Loading station
    		addSequential(new DriveCommand(73.17 *1.03, 0.4, 0, 2.75, 0.2));
    		addSequential(new DriveCommand(0, 0.3, -52.91 * 0.96, 1.25, 0.2));
    		addSequential(new DriveCommand(35.78 * 1.03, 0.4, 0, 1.5, 0.2));
    	}
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

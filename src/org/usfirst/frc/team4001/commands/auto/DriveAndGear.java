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

    	if(n == 1){ // Mid + push

        	addSequential(new DriveCommand(68.57 * 1.03, 0.5, 0, 3, 0.2)); 

        	addSequential(new GearHoldersFullOpen());
        	
        	addSequential(new GearPusherOut());
        	
        	addSequential(new DriveCommand(-24, 0.4,0, 1.5, 0.2));
        	addSequential(new GearPusherIn());

    	}
    	else if(n == 2){ //static Mid
    		
        	addSequential(new DriveCommand(-73 * 1.03, 0.4, 0, 3, 0.2));
    	}
    	else if (n == 3 ) { //Red Boiler
    		addSequential(new DriveCommand(-68 *1.03, 0.6, 0, 2.75, 0.2));
    		
    		addSequential(new DriveCommand(0, 0.6, -63.5, 1.5, 0.2));
    		
    		addSequential(new DriveCommand(-21 * 1.03, 0.5, 0, 2, 0.2));
    	}
    	else if (n == 4) { //Blue Boiler
    		addSequential(new DriveCommand(-68 *1.03, 0.6, 0, 2.75, 0.2));
    		addSequential(new DriveCommand(0, 0.6, 63.5 , 1.25, 0.2));
    		addSequential(new DriveCommand(-22 * 1.03, 0.5, 0, 2, 0.2));
    	}
    	else if (n == 5) { //Red Loading station
    		addSequential(new DriveCommand(-65, 0.4, 0, 2.75, 0.2));
    		addSequential(new DriveCommand(0, 0.48, 62, 1.25, 0.2));
    		addSequential(new DriveCommand(-16.5 * 1.03, 0.5, 0, 2, 0.2));
    	}
    	else if (n == 6) { //Blue Loading station
    		addSequential(new DriveCommand(-65, 0.4, 0, 2.75, 0.2));
    		addSequential(new DriveCommand(0, 0.48, -62 , 1.25, 0.2));
    		addSequential(new DriveCommand(-18 * 1.03, 0.5, 0, 2, 0.2));
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

package org.usfirst.frc.team4001.commands.auto;

import org.usfirst.frc.team4001.robot.commands.PlaceGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveAndGear extends CommandGroup {
	
	public String ln;
	public int n;

    public DriveAndGear(String ln, int n) {
    	
    	this.ln = ln;
    	this.n = n;
    	// check for bumper dimensions
    	if(ln=="Key"){
        	//Ryerson measurements
    		//addSequential(new DriveCommand(39.19, 0.5, 0, 1, 0.2));
        	addSequential(new DriveCommand(86.8, 0.55, 0, 3.5, 0.2)); 
//        	addSequential(new DriveCommand(0, 0.3, 35*n, 0.75, 0.2));
        	//addSequential(new DriveCommand(72.12, 0.5, 0, 3.5, 0.2));
//        	addSequential(new DriveCommand(61, 0.65, 0, 1.7, 0.2));
        	addSequential(new DriveCommand(0, 0.4, (-60)*n, 1, 0.2));
        	addSequential(new DriveCommand(39.5, 0.5, 0, 2.25, 0.2));
    	}
    	else if(ln=="Ret"){
    		//Ryerson measurements
    		addSequential(new DriveCommand(85.8, 0.5, 0, 3.5, 0.2));
//        	addSequential(new DriveCommand(0, 0.5, (-29)*n, 1, 0.2));
//        	addSequential(new DriveCommand(72.12, 0.5, 0, 3.5, 0.2));
        	addSequential(new DriveCommand(0, 0.5, 60*n, 1, 0.2));
        	addSequential(new DriveCommand(39.5, 0.5, 0, 2.25, 0.2));
    	}
    	//addSequential(new PlaceGear());
    	addSequential(new GearPusherAuto());
    	addSequential(new DriveCommand(-12, 0.3, 0, 1, 0.2));
    	
    	
    	
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

package org.usfirst.frc.team4001.commands.auto;

import org.usfirst.frc.team4001.robot.commands.PlaceGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveRetLineAndGear extends CommandGroup {
	
	public static int n;

    public DriveRetLineAndGear(int n) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	this.n = n;
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    	
    	//1-turn sequence
    	addSequential(new DriveCommand(15.6, 0.5, 0, 1, 0.2));
    	addSequential(new DriveCommand(0, 0.5, (-20)*n, 1, 0.2));
    	addSequential(new DriveCommand(213.3, 0.5, 0, 3.5, 0.2));
    	addSequential(new DriveCommand(0, 0.5, 140*n, 1, 0.2));
    	addSequential(new DriveCommand(42.04, 0.5, 0, 1.5, 0.2));
    	addSequential(new PlaceGear());

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}

package org.usfirst.frc.team4001.commands.auto;

import org.usfirst.frc.team4001.robot.commands.PlaceGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveKeyLineAndGear extends CommandGroup {
	
	public static int n;

    public DriveKeyLineAndGear(int n) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	this.n = n;
    	/*
    	 * 2-turn sequence
    	addSequential(new DriveCommand(15.6, 0.5, 0, 1, 0.2));
    	addSequential(new DriveCommand(0, 0.5, 30*n, 1, 0.2));
    	addSequential(new DriveCommand(151.55, 0.5, 0, 3, 0.2));
    	addSequential(new DriveCommand(0, 0.5, (-73)*n, 1.2, 0.2));
    	addSequential(new DriveCommand(70.16, 0.5, 0, 2, 0.2));
    	addSequential(new DriveCommand(0, 0.5, (-80)*n, 1, 0.2));
    	addSequential(new DriveCommand(16.26, 0.5, 0, 1, 0.2));
    	addSequential(new PlaceGear());
    	 */
    	
    	//1-turn sequence
    	addSequential(new DriveCommand(15.6, 0.5, 0, 1, 0.2));
    	addSequential(new DriveCommand(0, 0.5, 20*n, 1, 0.2));
    	addSequential(new DriveCommand(213.3, 0.5, 0, 3.5, 0.2));
    	addSequential(new DriveCommand(0, 0.5, (-140)*n, 1, 0.2));
    	addSequential(new DriveCommand(31.64, 0.5, 0, 1.5, 0.2));
    	addSequential(new PlaceGear());
    	

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

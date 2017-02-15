package org.usfirst.frc.team4001.commands.auto;

import org.usfirst.frc.team4001.robot.commands.PlaceGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveAndPlacePosition2 extends CommandGroup {

    public DriveAndPlacePosition2() {
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
    	
    	//addSequential(new DriveCommand(58.36, 0.5, 0, 1.5, 0.2));
    	addSequential(new DriveCommand(64.36, 0.5, 0, 1.5, 0.2));
    	addSequential(new PlaceGear());
    }
}

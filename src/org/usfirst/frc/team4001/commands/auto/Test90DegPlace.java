package org.usfirst.frc.team4001.commands.auto;

import org.usfirst.frc.team4001.robot.commands.PlaceGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Test90DegPlace extends CommandGroup {

    public Test90DegPlace() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	addSequential(new DriveCommand(151, 0.5, 0, 4, 0.2));
    	//addSequential(new TurnCommand(-90, 0.3, 3));
    	addSequential(new DriveCommand(0, 0.5, -90, 3, 0.2));
    	addSequential(new DriveCommand(176, 0.5, 0, 4, 0.2));
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

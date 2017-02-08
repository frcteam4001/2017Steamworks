package org.usfirst.frc.team4001.robot.commands;

import org.usfirst.frc.team4001.commands.auto.DriveCommand;
import org.usfirst.frc.team4001.commands.auto.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveRedRightToGear extends CommandGroup {

    public DriveRedRightToGear() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	addSequential(new DriveCommand(15.6, 0.5, 0, 3, 0.2));
    	addSequential(new TurnCommand(20, 0.5, 2));
    	addSequential(new DriveCommand(213.3, 0.5, 0, 3, 0.2));
    	addSequential(new TurnCommand(-140, 0.5, 3));
    	addSequential(new DriveCommand(78.04, 0.5, 0, 3, 0.2));
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

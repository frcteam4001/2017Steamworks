package org.usfirst.frc.team4001.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4001.commands.auto.TurnCommand;
import org.usfirst.frc.team4001.robot.Robot;

/**
 *
 */
public class Align extends CommandGroup {

    public Align() {
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
    	
    	while (!Robot.drive.ultrasonicsOnSameSurface()) {
    		new TurnCommand(Robot.drive.getBlindTurnAngle(), 0.5, 1);
    	}
    	new TurnCommand(Robot.drive.getTurnAngle(), 0.5, 1);
    }
}

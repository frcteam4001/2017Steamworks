package org.usfirst.frc.team4001.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4001.commands.auto.DriveCommand;
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
    	
    	//while (!Robot.drive.ultrasonicsOnSameSurface()) {
    		//addSequential(new TurnCommand(Robot.drive.getBlindTurnAngle(), 0.5, 1));
    	//}
    	//while (!Robot.drive.isAligned()) {
    		//double angle = Robot.drive.getTurnAngle();
    		//SmartDashboard.putNumber("angle", Robot.drive.getTurnAngle());
    		addSequential(new DriveCommand(0, 0.5,Robot.drive.getTurnAngle(), 2));
    	//}
    }
}

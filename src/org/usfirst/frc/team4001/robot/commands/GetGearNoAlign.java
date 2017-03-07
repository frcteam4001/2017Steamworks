package org.usfirst.frc.team4001.robot.commands;

import org.usfirst.frc.team4001.commands.auto.CurtainDown;
import org.usfirst.frc.team4001.commands.auto.CurtainUp;
import org.usfirst.frc.team4001.commands.auto.DriveToGearLoadingDistance;
import org.usfirst.frc.team4001.commands.auto.TurnRoller;
import org.usfirst.frc.team4001.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GetGearNoAlign extends CommandGroup {

    public GetGearNoAlign() {
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
    	//if (Robot.pusher.pusherIsBack()){
    		addParallel(new CurtainUp());
        	addSequential(new GearHoldersFullOpen(false));
            
            addSequential(new TurnRoller());
            addSequential(new GearCloseHolders());
            addSequential(new CurtainDown());
    	//}
    	
        
    	
    }
}

package org.usfirst.frc.team4001.robot.commands;

import org.usfirst.frc.team4001.robot.NumberConstants;
import org.usfirst.frc.team4001.robot.Robot;

import org.usfirst.frc.team4001.commands.auto.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4001.robot.Robot;


/**
 *
 */
public class GetGear extends CommandGroup {

    public GetGear() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

    	
    	addParallel(new GearHoldersFullOpen(true));
        addSequential(new Align());
        
        addSequential(new DriveToGearLoadingDistance());
        
        addParallel(new CurtainUp());
        addSequential(new TurnRoller());
        addSequential(new GearCloseHolders());
        addSequential(new CurtainDown());
        
        
    }
}

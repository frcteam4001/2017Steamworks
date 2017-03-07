package org.usfirst.frc.team4001.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4001.robot.*;
import org.usfirst.frc.team4001.robot.commands.GearHoldersFullOpen;
import org.usfirst.frc.team4001.robot.commands.PusherCommand;

/**
 *
 */
public class GearPusher extends CommandGroup {	

    public  GearPusher() {
    	
    	//addSequential(new GetGearAutoAlign())
    	//addSequential(new PlaceGear())
    	//if (!Robot.geardrop.get_HoldersOpened()){
    	System.out.println("CurrentZone: ");
    	System.out.println(Robot.geardrop.getCurrentZone());
    	
    	//if(Robot.geardrop.getCurrentZone() > 1 && Robot.geardrop.getCurrentZone() < 5){
    	addSequential(new GearHoldersFullOpen());
    	addSequential(new PusherCommand());
    
    	//}
    	
    	
    	
    	
    	
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

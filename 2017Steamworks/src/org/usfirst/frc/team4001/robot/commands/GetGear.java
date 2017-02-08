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

    	//Level with loading station
        addSequential(new Align());
        
        //Drive to the correct distance from the loading station
//        double distanceFromLoadingStation = (Robot.drive.getLeftUltrasonicDist() + Robot.drive.getRightUltrasonicDist()) / 2;
//        double travelDistance = distanceFromLoadingStation - NumberConstants.distance_from_loading_station;
//        addSequential(new DriveCommand(travelDistance, 0.8, 0, 1.5, 0.5));
        
        addParallel(new TurnRoller());
        addParallel(new CurtainUp());
    }
}

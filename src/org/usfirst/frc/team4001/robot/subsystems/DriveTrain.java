package org.usfirst.frc.team4001.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4001.robot.RobotMap;
import com.ctre.CANTalon;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final CANTalon frontLeftMotor = new CANTalon(RobotMap.front_left_motor);
	private final CANTalon rearLeftMotor = new CANTalon(RobotMap.rear_left_motor);
	private final CANTalon frontRightMotor = new CANTalon(RobotMap.front_right_motor);
	private final CANTalon rearRightMotor = new CANTalon(RobotMap.rear_right_motor);
	private final AnalogGyro gyro = new AnalogGyro(RobotMap.gyro);
	
	private final RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor,frontRightMotor , rearRightMotor);
	
	//keep tract of if the angle had been reseted, for driving continuous stright line
	private boolean reseted = false;
	//a really small value, use to turn steering back to parallel
	private static final double change = 0.05;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void drive(double foward, double turn)
    {
    	if(turn == 0)//if turning value is zero
    	{
    		if(reseted == false)
    		{
    			resetangle();
    			drivestraight(foward);
    		}
    		else
    		{
    			drivestraight(foward);
    		}
    	}
    	else
    	{
    		//drives the robot
    		drive.arcadeDrive(foward, turn, false);
    		reseted = false;
    	}
    }
    
    private void resetangle()
    {
    	gyro.reset();
    	reseted = true;
    }
    
    private void drivestraight(double f)
    {
    	double gyroinput = gyro.getAngle();
    	
    	if(gyroinput < 0)//if the robot is tilted left
    	{
    		drive.arcadeDrive(f, change);//change can also be scaled by the angle
    	}
    	else if(gyroinput > 0)//if the robot is tilted right
    	{
    		drive.arcadeDrive(f, -change);
    	}
    	else
    	{
    		drive.arcadeDrive(f, 0);
    	}
    }
    
    //stops the robot
    public void hardstop()
    {
    	drive.arcadeDrive(0, 0);
    }
}

=======
package org.usfirst.frc.team4001.robot.subsystems;


import org.usfirst.frc.team4001.robot.ElectricalConstants;
import com.team4001.lib.util.PIDController;
import org.usfirst.frc.team4001.robot.commands.ArcadeDrive;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import com.ctre.*;
import org.usfirst.frc.team4001.robot.NumberConstants;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    //motors
	private final CANTalon frontLeftMotor;
	private final CANTalon frontRightMotor;
	private final CANTalon rearLeftMotor;
	private final CANTalon rearRightMotor;
	
	//drive train
	private final RobotDrive drive;
		
	//encoders
	private Encoder leftDriveEncoder;
	private Encoder rightDriveEncoder;
	
	// ultrasonic sensors
	private final AnalogInput ultrasonic_left;
	private final AnalogInput ultrasonic_right;
	//private final Potentiometer pot = new AnalogPotentiometer(1,10,0);
	
	//Gyro
	private final ADXRS450_Gyro gyro;
	
	//PID controllers
	public PIDController drivePID;
	public PIDController gyroPID;
	
	
	public DriveTrain() {
		//initialize motors
		frontLeftMotor = new CANTalon(ElectricalConstants.DRIVETRAIN_FRONT_LEFT);
		frontLeftMotor.setInverted(ElectricalConstants.DRIVETRAIN_FRONT_LEFT_REVERSE);
		frontRightMotor = new CANTalon(ElectricalConstants.DRIVETRAIN_FRONT_RIGHT);
		frontRightMotor.setInverted(ElectricalConstants.DRIVETRAIN_FRONT_RIGHT_REVERSE);
		rearLeftMotor = new CANTalon(ElectricalConstants.DRIVETRAIN_REAR_LEFT);
		rearLeftMotor.setInverted(ElectricalConstants.DRIVETRAIN_REAR_LEFT_REVERSE);
		rearRightMotor = new CANTalon(ElectricalConstants.DRIVETRAIN_REAR_RIGHT);
		rearRightMotor.setInverted(ElectricalConstants.DRIVETRAIN_REAR_RIGHT_REVERSE);
		
		//initialize Drive Train
		drive = new RobotDrive(frontLeftMotor, rearLeftMotor,frontRightMotor , rearRightMotor);
		
		//initialize encoders
		leftDriveEncoder = new Encoder(ElectricalConstants.LEFT_DRIVE_ENCODER_A,
				ElectricalConstants.LEFT_DRIVE_ENCODER_B, ElectricalConstants.leftDriveTrainEncoderReverse,
				Encoder.EncodingType.k4X);
		leftDriveEncoder.setReverseDirection(ElectricalConstants.leftDriveTrainEncoderReverse);
		leftDriveEncoder.setDistancePerPulse(ElectricalConstants.driveEncoderDistPerTick);

		rightDriveEncoder = new Encoder(ElectricalConstants.RIGHT_DRIVE_ENCODER_A,
				ElectricalConstants.RIGHT_DRIVE_ENCODER_B, ElectricalConstants.rightDriveTrainEncoderReverse,
				Encoder.EncodingType.k4X);
		rightDriveEncoder.setDistancePerPulse(ElectricalConstants.driveEncoderDistPerTick);
		rightDriveEncoder.setReverseDirection(ElectricalConstants.rightDriveTrainEncoderReverse);
		
		//initialize ultrasonic sensors
		ultrasonic_left = new AnalogInput(ElectricalConstants.DRIVETRAIN_ULTRASONIC_LEFT);
		ultrasonic_right = new AnalogInput(ElectricalConstants.DRIVETRAIN_ULTRASONIC_RIGHT);
		//private final Potentiometer pot = new AnalogPotentiometer(1,10,0);
		
		//initialize gyro
		gyro = new ADXRS450_Gyro();
		gyro.calibrate();
		gyro.reset();
		
		
		//initialize PID controllers
		drivePID = new PIDController(NumberConstants.pDrive, NumberConstants.iDrive, NumberConstants.dDrive);
		gyroPID = new PIDController(NumberConstants.pGyro, NumberConstants.iGyro, NumberConstants.dGyro);
		
		
		
		
	}
	
	
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new ArcadeDrive());
    }
    
    
    public void arcadeDrive(double forward, double turn){
    	drive.arcadeDrive(0.9 * forward, 0.9 * turn,false);

    } 
    
    public void hardStop() {
    	drive.arcadeDrive(0, 0);
    }
    
    
    
    /**
	 * Sends supplied power value to the left drive motors.
	 *
	 * @param power
	 *            Power value sent to motors (-1.0 to 1.0)
	 */
	public void runLeftDrive(double power) {
		frontLeftMotor.set(power);
		rearLeftMotor.set(power);
	}

	/**
	 * Sends supplied power value to the right drive motors.
	 *
	 * @param poewr
	 *            Power value sent to motors (-1.0 to 1.0)
	 */
	public void runRightDrive(double power) {
		frontRightMotor.set(power);
		rearRightMotor.set(power);
	}

	/**
	 * Gets the average distance between both encoders.
	 *
	 * @return Returns the average distance
	 */
	public double getAverageDistance() {
		return (getLeftEncoderDist() + getRightEncoderDist()) / 2;
	}

	/**
	 * Using both PID controllers (drive & gyro), the drivetrain will move to
	 * target at given speed and angle
	 *
	 * @param setPoint
	 *            The set point in inches
	 * @param speed
	 *            The speed (0.0 to 1.0)
	 * @param setAngle
	 *            The set angle in degrees
	 * @param epsilon
	 *            How close robot should be to target to consider reached
	 */
	public void driveStraight(double setPoint, double speed, double setAngle, double epsilon) {
		double output = drivePID.calcPIDDrive(setPoint, getAverageDistance(), epsilon);
		double angle = gyroPID.calcPID(setAngle, getYaw(), epsilon);
		
		runLeftDrive(-(output + angle) * speed);
		runRightDrive(-(-output + angle) * speed);
	}

	/**
	 * Used to move robot without a drive PID controller at a given speed, while
	 * at the angle given.
	 *
	 * @param setAngle
	 *            The set angle in degrees
	 * @param speed
	 *            The speed (-1.0 - 1.0)
	 */
	public void driveAngle(double setAngle, double speed) {
		double angle = gyroPID.calcPID(setAngle, getYaw(), 1);

		runLeftDrive(speed + angle);
		runRightDrive(-speed + angle);
	}

	/**
	 * Using a PID controller, turns the robot to given angle with the given
	 * speed.
	 *
	 * @param setAngle
	 *            The set angle in degrees
	 * @param speed
	 *            The speed (0.0 - 1.0)
	 * @param epsilon
	 *            How close robot should be to target to consider reached
	 */
	public void turnDrive(double setAngle, double speed, double epsilon) {
		double angle = gyroPID.calcPID(setAngle, getYaw(), epsilon);

		runLeftDrive(-angle * speed);
		runRightDrive(-angle * speed);
	}
	
	
	
    
    /**
	 * Resets the encoder AND gyro to zero.
	 */
	public void reset() {
		resetEncoders();
		resetGyro();
	}
	
    
    //////////encoder methods
    /**
	 * This function returns the distance traveled from the left encoder in
	 * inches.
	 *
	 * @return Returns distance traveled by encoder in inches
	 */
	public double getLeftEncoderDist() {
		return leftDriveEncoder.getDistance();
	}

	/**
	 * This function returns the distance traveled from the right encoder in
	 * inches.
	 *
	 * @return Returns distance traveled by encoder in inches
	 */
	public double getRightEncoderDist() {
		return rightDriveEncoder.getDistance();
	}

	/**
	 * This function returns the raw value from the left encoder.
	 *
	 * @return Returns raw value from encoder
	 */
	public double getLeftEncoderRaw() {
		return leftDriveEncoder.getRaw();
	}

	/**
	 * This function returns the raw value from the right encoder.
	 *
	 * @return Returns raw value from encoder
	 */
	public double getRightEncoderRaw() {
		return rightDriveEncoder.getRaw();
	}

	/**
	 * This function returns the rate the left encoder is moving at in
	 * inches/sec.
	 *
	 * @return Returns rate of encoder in inches/sec
	 */
	public double getLeftEncoderRate() {
		return leftDriveEncoder.getRate();
	}

	/**
	 * This function returns the rate the right encoder is moving at in
	 * inches/sec.
	 *
	 * @return Returns rate of encoder in inches/sec
	 */
	public double getRightEncoderRate() {
		return rightDriveEncoder.getRate();
	}

	/**
	 * Resets both left and right encoders.
	 */
	public void resetEncoders() {
		leftDriveEncoder.reset();
		rightDriveEncoder.reset();
	}
    
    ////////gyro methods
	public double getYaw(){
		return gyro.getAngle();
	}
	
	public void resetGyro() {
		gyro.reset();
	}
	
	

	/**
	 * Determines if both sensors are fixed on the same surface
	 * @return true if both sensors are on the same surface, else false
	 */
	public boolean ultrasonicsOnSameSurface() {
		if (Math.abs(getLeftUltrasonicDist() - getRightUltrasonicDist()) <= NumberConstants.max_ultrasonic_reading_difference) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns the angle at which the robot must turn when sensors are not pointing at the same 
	 * surface based on the direction that it must turn to have the sensors pointing at the same 
	 * surface.
	 * @return angle
	 */
	public double getBlindTurnAngle(){
		if (getLeftUltrasonicDist() > getRightUltrasonicDist()) {
			return NumberConstants.blind_turn_angle;
		} else {
			return -1.0 * NumberConstants.blind_turn_angle;
		}
	}
	
	public double getRawIRLeft(){
		double reading = 0;
		for (int i = 0; i < 200; i++){
			reading += ultrasonic_left.getAverageVoltage();
		}
		reading /= 200;
		return reading;
	}
	
	public double getRawIRRight(){
		double reading = 0;
		for (int i = 0; i < 200; i++){
			reading += ultrasonic_right.getAverageVoltage();
		}
		reading /= 200;
		return reading;
	}
	
	/////////ultrasonic methods
	/**
	 * Returns the reading of the left ultrasonic sensor in inches
	 * @return Distance in inches
	 */
	public double getLeftUltrasonicDist() {
		return ((58/(getRawIRLeft() + 0.09))/2.54)*1.08;
	}
	
	/**
	 * Returns the reading of the right ultrasonic sensor in inches
	 * @return Distance in inches
	 */
	public double getRightUltrasonicDist() {
		return ((58/getRawIRRight())/2.54)*1.05;
	}
    
	
	/**
	 * Calculates and returns the angle, in degrees, at which the robot must turn so it is 
	 * alligned with the surface in front of it. Assumes both ultrasoncis are pointing at the 
	 * same surface.
	 * @return angle in degrees 
	 */
    public double getTurnAngle() {
//    	if (isAligned()) {
//    		return 0.0;
//    	} else {
    		double angleWithSurface = Math.toDegrees(Math.atan((NumberConstants.distance_between_sensors) / (getLeftUltrasonicDist() - getRightUltrasonicDist())));
    		double turnAngle = Math.signum(angleWithSurface) * (90.0 - Math.abs(angleWithSurface));
    		System.out.println(turnAngle);
    		return turnAngle;
//    	}
    }
    /**
     * Determines if the robot is aligned with the surface in front of it.
     * @return true if aligned
     */
    public boolean isAligned() {
    	if (Math.abs(getLeftUltrasonicDist()-getRightUltrasonicDist()) <= NumberConstants.aligned_tolerance) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
}


package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;
import org.usfirst.frc.team5951.robot.commands.chassis.ArcadeDrive;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import util.ChassisMath;

/**
 * @author Yair
 */
public class ChassisArcade extends Subsystem {

	// Talons
	private CANTalon chassisLeftFront;
	private CANTalon chassisLeftRear;
	private CANTalon chassisRightFront;
	private CANTalon chassisRightRear;

	// Variables
	public static final double k_JOYSTICK_DEADBAND = 0.15;

	// Solenoids (Shifters)
	private DoubleSolenoid shiftersPiston;

	// Encoders
	private Encoder chassisEncoderLeft;
	private Encoder chassisEncoderRight;

	// Gyro
	private ADXRS450_Gyro gyro;

	// Variables
	public final double k_GYRO_DISPLACEMENT = 1.013370865587614;
	public final double k_ENCODERS_DISTANCE_PER_PULSE = (1.0 / 1457.471733522452);
	private int chassisMultiplyer;
	private boolean fastMode = false;

	// PID values
	public final double kP_DISTANCE = 8;
	public final double kP_ANGLE = 0.15;

	/**
	 * Constructor for the ChassisArcade class, initializes components.
	 */
	public ChassisArcade() {
		// Talons init
		chassisLeftFront = new CANTalon(RobotMap.k_CHASSIS_LEFT_FRONT_TALON);
		chassisLeftRear = new CANTalon(RobotMap.k_CHASSIS_LEFT_REAR_TALON);
		chassisRightFront = new CANTalon(RobotMap.k_CHASSIS_RIGHT_FRONT_TALON);
		chassisRightRear = new CANTalon(RobotMap.k_CHASSIS_RIGHT_REAR_TALON);

		chassisLeftFront.changeControlMode(TalonControlMode.PercentVbus);
		chassisLeftRear.changeControlMode(TalonControlMode.Follower);
		chassisRightFront.changeControlMode(TalonControlMode.PercentVbus);
		chassisRightRear.changeControlMode(TalonControlMode.Follower);

		chassisLeftFront.enableBrakeMode(true);
		chassisLeftRear.enableBrakeMode(true);
		chassisRightFront.enableBrakeMode(true);
		chassisRightRear.enableBrakeMode(true);

		chassisRightFront.setInverted(true);
		// chassisLeftFront.setInverted(true);
		// chassisRightRear.reverseOutput(true);
		// chassisLeftRear.reverseOutput(true);

		// Pneumatics Init
		shiftersPiston = new DoubleSolenoid(RobotMap.k_PCM, RobotMap.k_CHASSIS_SHIFTERS_OPEN,
				RobotMap.k_CHASSIS_SHIFTERS_CLOSE);
		shiftersPiston.set(Value.kReverse);

		// Gyro init
		gyro = new ADXRS450_Gyro(Port.kOnboardCS0);

		// Encoders init
		chassisEncoderLeft = new Encoder(RobotMap.k_CHASSIS_ENCODER_LEFT_A, RobotMap.k_CHASSIS_ENCODER_LEFT_B);
		chassisEncoderRight = new Encoder(RobotMap.k_CHASSIS_ENCODER_RIGHT_A, RobotMap.k_CHASSIS_ENCODER_RIGHT_B);

		chassisEncoderLeft.setReverseDirection(true);

		chassisEncoderLeft.setDistancePerPulse(k_ENCODERS_DISTANCE_PER_PULSE);
		chassisEncoderRight.setDistancePerPulse(k_ENCODERS_DISTANCE_PER_PULSE);

		chassisMultiplyer = 1;
	}

	/**
	 * Drives the robot with values from the joystick using the
	 * {@link ChassisMath}'s math function.
	 * 
	 * @param moveValue
	 *            - Joystick's Y value
	 * @param rotateValue
	 *            - Joystick's X value
	 */
	public void arcadeDrive(Joystick stick) {
		double[] chassisValues = ChassisMath.calculatePower(stick.getY(), stick.getX());

		setLeftPower(chassisValues[0]);
		setRightPower(chassisValues[1]);
	}

	public void arcadeDrive(double moveValue, double rotateValue) {
		double[] chassisValues = ChassisMath.calculatePower(moveValue * chassisMultiplyer, rotateValue);

		setLeftPower(chassisValues[0]);
		setRightPower(chassisValues[1]);
	}

	/**
	 * Sets the power to the left side of the chassis
	 * 
	 * @param power
	 *            - Power to give
	 */
	public void setLeftPower(double power) {
		this.chassisLeftFront.set(power);
		this.chassisLeftRear.set(this.chassisLeftFront.getDeviceID());
	}

	/**
	 * Sets the power to the right side of the chassis
	 * 
	 * @param power
	 *            - Power to give
	 */
	public void setRightPower(double power) {
		this.chassisRightFront.set(power);
		this.chassisRightRear.set(this.chassisRightFront.getDeviceID());
	}

	/**
	 * Stops the chassis. Disables all motors.
	 */
	public void stopChassis() {
		this.setRightPower(0);
		this.setLeftPower(0);
	}

	public double getAngle() {
		return this.gyro.getAngle();
	}

	/**
	 * Resets gyro
	 */
	public void resetGyro() {
		this.gyro.reset();
	}

	/**
	 * Shifts the chassis into the high gear.
	 */
	public void switchToFastGear() {
		this.shiftersPiston.set(Value.kForward);
		this.fastMode = true;
		SmartDashboard.putString("Chassis mode: ", "Fast");
	}

	/**
	 * Shifts the chassis into the low gear.
	 */
	public void switchToStrongGear() {
		this.shiftersPiston.set(Value.kReverse);
		this.fastMode = false;
		SmartDashboard.putString("Chassis mode: ", "Strong");
	}

	/**
	 * Toggles the shifters between high and low gear.
	 */
	public void toggleShifters() {
		if (fastMode) {
			this.switchToStrongGear();
		} else {
			this.switchToFastGear();
		}
	}

	/**
	 * Resets encoders.
	 */
	public void resetEncoders() {
		this.chassisEncoderLeft.reset();
		this.chassisEncoderRight.reset();
	}

	/**
	 * Returns the current value of the left encoder
	 * 
	 * @return
	 */
	public double getLeftEncoderValue() {
		return this.chassisEncoderLeft.getDistance();
	}

	/**
	 * Returns the right encoder value
	 * 
	 * @return
	 */
	public double getRightEncoderValue() {
		return this.chassisEncoderRight.getDistance();
	}

	/**
	 * Returns the average between the encoders.
	 */
	public double getAvgEncoderValue() {
		return (this.chassisEncoderLeft.getDistance() + this.chassisEncoderRight.getDistance()) / 2.0;
	}

	/**
	 * Calibrates the gyro
	 */
	public void calibrateGyro() {
		this.gyro.calibrate();
	}

	/**
	 * Inverts forward and reverse of chassis
	 */
	public void invertChassis() {
		this.chassisMultiplyer = 0 - this.chassisMultiplyer;
	}

	/**
	 * Sets the multiplyer to the wanted value
	 * 
	 * @param value
	 *            - Multiplyer value
	 */
	public void setChassisMultiplyer(int value) {
		this.chassisMultiplyer = 1;
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());
	}
}

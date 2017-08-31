package org.usfirst.frc.team5951.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Ports for climbing subsystem 
	public static final int k_CANTALON_CLIMBING = 0;

	//Ports for gear collector subsystem
	public static final int k_CANTALON_COLLECTOR = 1;
	public static final int k_CANTALON_RAISE = 2;
	
	//Ports for HPGeat subsystem- not real
	public static final int k_SLIDE_OPEN = 0;
	public static final int k_SLIDE_CLOSE = 1;
	public static final int k_PUSH_OPEN= 4;
	public static final int k_PUSH_CLOSE= 5;
	public static final int k_RAISE_OPEN= 6;
	public static final int k_RAISE_CLOSE= 7;	
	
	//Joysticks ports
	public static final int k_SUBSYSTEMS_CONTROLLER_PORT = 0;
	public static final int k_DRIVERS_CONTROLLER_PORT = 1;

	
	// Chassis
	// Robot B ports
	public static final int k_CHASSIS_RIGHT_FRONT_TALON = 3;
	public static final int k_CHASSIS_RIGHT_REAR_TALON = 4;
	public static final int k_CHASSIS_LEFT_FRONT_TALON = 1;
	public static final int k_CHASSIS_LEFT_REAR_TALON = 2;
	
	public static final int k_PCM = 0;

	public static final int k_CHASSIS_ENCODER_LEFT_A = 4;
	public static final int k_CHASSIS_ENCODER_LEFT_B = 5;
	public static final int k_CHASSIS_ENCODER_RIGHT_A = 6;
	public static final int k_CHASSIS_ENCODER_RIGHT_B = 7;
	
	public static final int k_CHASSIS_SHIFTERS_OPEN = 3;
	public static final int k_CHASSIS_SHIFTERS_CLOSE = 2;
}

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
	
	//Joystick buttons port
	public static final int k_SLIDE_BUTTON_PORT = 0;
	public static final int k_PUT_GET_BUTTON_PORT = 1;
	public static final int k_PUT_BUTTON_PORT = 2;
	public static final int k_GET_BUTTON_PORT = 3;
	
	
}

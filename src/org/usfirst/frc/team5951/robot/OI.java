package org.usfirst.frc.team5951.robot;


import SteamworksPractice.src.HPGear.AutomaticHPGear;
import SteamworksPractice.src.HPGear.CloseHPGear;
import SteamworksPractice.src.HPGear.OpenHPGear;
import SteamworksPractice.src.HPGear.ToggleSlide;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// subsystem controller
	public static final XboxController k_SUBSYSTEMS_CONTROLLER = new XboxController(
			RobotMap.k_SUBSYSTEMS_CONTROLLER_PORT);
	public static final Joystick k_DRIVER_JOYSTICK = new Joystick(
			RobotMap.k_DRIVERS_CONTROLLER_PORT);
	// Buttons
	public static final JoystickButton k_SLIDE_BUTTON = new JoystickButton(k_SUBSYSTEMS_CONTROLLER, xboxPorts.Y.get());
	public static final JoystickButton k_AUTO_HPGEAR_BUTTON = new JoystickButton(k_SUBSYSTEMS_CONTROLLER,
			xboxPorts.A.get());
	public static final JoystickButton k_PUT_BUTTON = new JoystickButton(k_SUBSYSTEMS_CONTROLLER, xboxPorts.X.get());
	public static final JoystickButton k_GET_BUTTON = new JoystickButton(k_SUBSYSTEMS_CONTROLLER, xboxPorts.B.get());

	public OI() {
		
	     k_SLIDE_BUTTON.whenPressed(new ToggleSlide());
	     
	     
		
		
		
			k_AUTO_HPGEAR_BUTTON.whenPressed(new AutomaticHPGear());
		
			k_PUT_BUTTON .whenPressed(new OpenHPGear());
			
			k_GET_BUTTON .whenPressed(new CloseHPGear());
			
			
			
			//joysticks and POV
			
			
	}
}

enum xboxPorts {
	Y(0), A(1), X(2), B(3);

	private int port;

	xboxPorts(int port) {
		this.port = port;
	}

	public int get() {
		return port;
	}
}
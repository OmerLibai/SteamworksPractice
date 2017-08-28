package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.robot.subsystems.HPGear;

import SteamworksPractice.src.HPGear.CloseSlide;
import SteamworksPractice.src.HPGear.GetGear;
import SteamworksPractice.src.HPGear.OpenSlide;
import SteamworksPractice.src.HPGear.PutGear;
import SteamworksPractice.src.HPGear.PutGetGear;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//subsystem controller
	public static final XboxController k_SUBSYSTEMS_CONTROLLER = new XboxController(RobotMap.k_SUBSYSTEMS_CONTROLLER_PORT);
	
	//Buttons
	public static final JoystickButton k_SLIDE_BUTTON = new JoystickButton(k_SUBSYSTEMS_CONTROLLER, xboxPorts.Y.get());
	public static final JoystickButton k_PUT_GET_BUTTON = new JoystickButton(k_SUBSYSTEMS_CONTROLLER, xboxPorts.A.get());
    public static final JoystickButton k_PUT_BUTTON = new JoystickButton (k_SUBSYSTEMS_CONTROLLER, xboxPorts.X.get());
    public static final JoystickButton k_GET_BUTTON = new JoystickButton (k_SUBSYSTEMS_CONTROLLER, xboxPorts.B.get());
    private HPGear hpgear;
    
    
	public OI() {
		hpgear = new HPGear();
		if(hpgear.onOffSlide==true) {
			k_SLIDE_BUTTON.whenPressed(new OpenSlide());
		}
		else {
			k_SLIDE_BUTTON.whenPressed(new CloseSlide());
		}
		
			k_PUT_GET_BUTTON.whenPressed(new PutGetGear());
		
			k_PUT_BUTTON .whenPressed(new PutGear());
			
			k_GET_BUTTON .whenPressed(new GetGear());
			
			//joysticks and POV
			
			
	}
}

	enum xboxPorts {
		Y(0),
		A(1),
		X(2),
		B(3);
		
		private int port;
		
		xboxPorts(int port) {
			this.port = port;			
		}
		public int get() {
			return port;
		}
	}
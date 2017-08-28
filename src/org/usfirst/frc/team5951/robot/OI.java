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
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	public static final XboxController k_SUBSYSTEMS_CONTROLLER = new XboxController(RobotMap.k_SUBSYSTEMS_CONTROLLER_PORT);
	public static final JoystickButton k_SLIDE_BUTTON = new JoystickButton(k_SUBSYSTEMS_CONTROLLER, RobotMap.k_SLIDE_BUTTON_PORT);
	public static final JoystickButton k_PUT_GET_BUTTON = new JoystickButton(k_SUBSYSTEMS_CONTROLLER, RobotMap.k_PUT_GET_BUTTON_PORT);
    public static final JoystickButton k_PUT_BUTTON = new JoystickButton (k_SUBSYSTEMS_CONTROLLER,RobotMap.k_PUT_BUTTON_PORT);
    public static final JoystickButton k_GET_BUTTON = new JoystickButton (k_SUBSYSTEMS_CONTROLLER,RobotMap.k_GET_BUTTON_PORT);
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
			
	}
	
	
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new DriveStraight());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new DriveStraight());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new DriveStraight());
}

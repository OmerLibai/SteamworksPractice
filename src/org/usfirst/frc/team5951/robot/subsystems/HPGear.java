package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * HPGear subsystem: contains the Commands that this subsystem can do
 * 
 * Three private DoubleSolenoids (slide & push & raise)
 * one private boolean (onOffSlide) that says if the double solenoid is open or not 
 * nine command methods-
 * 	1. open the slide, opens the double solenoid (openSlide)
 * 	2. close the slide, closes the double solenoid (closeSlide)
 * 	3. no presser in double solenoid slide(disableSlide)
 *  4. open the push stick, opens the double solenoid (openPush)
 *  5. close the push stick, closes the double solenoid (closePush)
 *  6. no presser in double solenoid Push stick (disablePush)
 *  7. open the raiser, opens the double solenoid (openRaise)
 *  8. close the raiser, closes the double solenoid (closeRaise)
 *  9. no presser in double solenoid Raise (disableRaise)
 * default command- nothing
 */
public class HPGear extends Subsystem {
	private DoubleSolenoid slide;
	private DoubleSolenoid push;
	private DoubleSolenoid raise;
	public static boolean onOffSlide;
	
	/*
	 * In the constructor:
	 * slide is defined as a new double solenoid and the ports of it are set.
	 * slide is defined as a new double solenoid and the ports of it are set.
	 */
	
	public HPGear () {
		slide = new DoubleSolenoid(RobotMap.k_SLIDE_OPEN,RobotMap.k_SLIDE_CLOSE);
		push = new DoubleSolenoid(RobotMap.k_RAISE_OPEN, RobotMap.k_RAISE_CLOSE);
		raise = new DoubleSolenoid(RobotMap.k_RAISE_OPEN, RobotMap.k_RAISE_CLOSE);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub		
	}
	/*
	 * The openSlide command opens the slide double solenoid (forward)
	 */
	public void openSlide() {
		slide.set(Value.kForward);
	}
	/*
	 * The closeSlide command closes the slide double solenoid (reverse)
	 */
	public void closeSlide() {
		slide.set(Value.kReverse);
	}
	/*
	 * The disableSlide command gives no power to the the slide double solenoid (disable)
	 */
	public void disableSlide() {
		slide.set(Value.kOff);
	}
	/*
	 * The openPush command opens the Push double solenoid (forward)
	 */
	public void openPush() {
		push.set(Value.kForward);
	}
	/*
	 * The closePush command closes the push double solenoid (reverse)
	 */
	public void closePush() {
	push.set(Value.kReverse);	
	}
	/*
	 * The disablePush command gives no power to the the Push double solenoid (disable)
	 */
	public void disablePush() {
		push.set(Value.kOff);
	}
	/*
	 * The openRaise command opens the raise double solenoid (forward)
	 */
	public void openRaise() {
		raise.set(Value.kForward);
	}
	/*
	 * The closeRaise command closes the raise double solenoid (reverse)
	 */
	public void closeRaise() {
		raise.set(Value.kReverse);
	}
	/*
	 * The disableRaise command gives no power to the the raise double solenoid (disable)
	 */
	public void disableRaise() {
		raise.set(Value.kOff);
	}
	
}

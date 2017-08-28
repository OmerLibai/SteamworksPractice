package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * HPGear subsystem: contains the Commands that this subsystem can do
 * 
 * Two private DoubleSolenoids ()
 * Six command methods-
 * 	1. 
 * 	2. 
 * 	3.
 * default command-
 */
public class HPGear extends Subsystem {
	private DoubleSolenoid slide;
	private DoubleSolenoid push;
	private DoubleSolenoid raise;
	public static boolean onOffSlide;
	
	public HPGear () {
		slide = new DoubleSolenoid(RobotMap.k_SLIDE_OPEN,RobotMap.k_SLIDE_CLOSE);
		push = new DoubleSolenoid(RobotMap.k_RAISE_OPEN, RobotMap.k_RAISE_CLOSE);
		raise = new DoubleSolenoid(RobotMap.k_RAISE_OPEN, RobotMap.k_RAISE_CLOSE);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub		
	}
	
	public void openSlide() {
		slide.set(Value.kForward);
	}
	public void closeSlide() {
		slide.set(Value.kReverse);
	}
	public void disableSlide() {
		slide.set(Value.kOff);
	}
	public void openPush() {
		push.set(Value.kForward);
	}
	public void closePush() {
	push.set(Value.kReverse);	
	}
	public void disablePush() {
		push.set(Value.kOff);
	}
	public void openRaise() {
		raise.set(Value.kForward);
	}
	public void closeRaise() {
		raise.set(Value.kReverse);
	}
	public void disableRaise() {
		raise.set(Value.kOff);
	}
	
}

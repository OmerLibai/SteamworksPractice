package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Climbing subsystem: contains the Commands that this subsystem can do
 * 
 * One private CANTalon (cantalonClimbing)
 * Three command methods-
 * 	1. Full power one way (climbingUp)
 * 	2. Full power other way (climbingDown)
 * 	3. no power (stop)
 * default command- stop
 */

public class Climbing extends Subsystem{
	
	private CANTalon cantalonClimbing;
	
	/*
	 * In the constructor the cantalonCliming is defined as a new CANTalon and the port is set.
	 * 
	 * Then the CANTalon control mode changes to precentVbus:
	 * the motor can get speed from 1 to -1
	 */
	public Climbing () {
		cantalonClimbing = new CANTalon(RobotMap.k_CANTALON_CLIMBING);
		
		cantalonClimbing.changeControlMode(TalonControlMode.PercentVbus);
		
	}
	
	/*
	 * The default command method gives no power for the CANTalon
	 */
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		cantalonClimbing.set(0);
	
	}
	
	/*
	 * The climingUp method turns the cantalonClimbing to one side in the highest speed: 1
	 */
	public void climbingUp () {
		cantalonClimbing.set(1);
	}
	/*
	 * The climingDown method turns the cantalonClimbing to one side in the highest speed: -1
	 */
	public void climbingDown() {
		cantalonClimbing.set(-1);	
	}
	/*
	 * The stop method gives no speed for the cantalonClimbing
	 */
	public void stop () {	
		cantalonClimbing.set(0);
	}
		
		
	
	
	
	

}


 
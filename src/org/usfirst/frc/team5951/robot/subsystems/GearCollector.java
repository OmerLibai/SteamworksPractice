package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * Gear Collection subsystem: contains the Commands that this subsystem can do
 * 
 * Two private CANTalon (cantalonCollector & cantalonRaise)
 * Six command methods-
 * 	1. Taking in the gear in full power (inTake)
 * 	2. Taking out the gear in full power(outTake)
 * 	3. Sends no power to cantalonCollector (stopCollector)
 *  4. Lowers the gear in full power (lower)
 *  5. Raises the gear in full power (raise)
 *  6. Sends no power to cantalonRaise (stopRaise)
 *  
 * default command- stopRaise and stopCollector
 */
public class GearCollector extends Subsystem {
    private CANTalon cantalonCollector;
    private CANTalon cantalonRaise;
    
    /**
	 * In the constructor:
	 * the cantalonCollector is defined as a new CANTalon and the port is set.
	 * the cantalonRaise is defined as a new CANTalon and the port is set.
	 * 
	 * Then the CANTalons control mode changes to precentVbus:
	 * these CANTalons can get speed from 1 to -1
	 */
    public GearCollector() {
    	cantalonCollector = new CANTalon(RobotMap.k_CANTALON_COLLECTOR);
    	cantalonRaise = new CANTalon(RobotMap.k_CANTALON_RAISE);
    	cantalonCollector.changeControlMode(TalonControlMode.PercentVbus);
    	cantalonRaise.changeControlMode(TalonControlMode.PercentVbus);
    }
    /**
	 * The default command gives no power for the CANTalons
	 */
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	cantalonCollector.set(0);
	cantalonRaise.set(0);
		
	}
	
	/**
	 * The inTake command turns the cantalonCollectorn to one side in the highest speed: 1
	 */
	public void inTake() {
		cantalonCollector.set(-1);
	}
	/**
	 * The outTake command turns the cantalonCollectorn to the other side in the highest speed: 1
	 */
	public void outTake() {
		cantalonCollector.set(1);
		
	}
	/**
	 * The lower command turns the cantalonRaiser to one side in the highest speed: 1
	 */
	public void lower() {
		cantalonCollector.set(-1);
	}
	/**
	 * The raise command turns the cantalonRaise to the other side in the highest speed: 1
	 */
	public void raise() {
		cantalonCollector.set(1);
		
	}
	/**
	 * The stopCollector command gives no speed for the cantalonCollector
	 */
	public void stopCollector() {
		cantalonCollector.set(0);
	}
	/**
	 * The stopRaise command gives no speed for the cantalonRaise
	 */
	public void stopRaise() {
		cantalonRaise.set(0);
	}
	

}

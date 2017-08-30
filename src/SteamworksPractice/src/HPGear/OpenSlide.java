package SteamworksPractice.src.HPGear;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.HPGear;

import edu.wpi.first.wpilibj.command.Command;
/**
 * Contains one private object of HPGear class (hpgear)
 * A command that makes the robot open the slide (by using the method openSlide)
 */

public class OpenSlide extends Command {
	private HPGear hpgear;
	/**
	 * In the constructor the object hpgear is defined as a k_HPGEAR_SUBSYSTEM in 
	 * Robot class.
	 * It defines the subsystem that the comment refers to(GPGear) 
	 */
	public OpenSlide() {
		// Use requires() here to declare subsystem dependencies
		hpgear = Robot.k_HPGEAR_SUBSYSTEM;
		requires(hpgear);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}
	/**
	 * It runs the openSlide method until it is told to stop
	 */
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		hpgear.openSlide();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
	}


}

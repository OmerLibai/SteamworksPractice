package SteamworksPractice.src.GearCollecter;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.GearCollector;

import edu.wpi.first.wpilibj.command.Command;
/**
 * Contains one private object of GearCollector class (collector)
 * A command that makes the robot to take out a gear (by using the method outTake)
 * When the command ends or interrupted it runs the method stopCollector
 */
public class OutTakeCollectorCommand extends Command{
private GearCollector collector;
/**
 * In the constructor the object collector is defined as a k_GEARCOLLECTOR_SUBSYSTEM in 
 * Robot class.
 * It defines the subsystem that the comment refers to(GearCollector) 
 */
	public OutTakeCollectorCommand() {
		collector = Robot.k_GEAR_COLLECTER_SUBSYSTEM;
		requires(collector);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	/**
	 * It runs the outTake method until it is told to stop
	 */
	@Override
	protected void execute() {
		collector.outTake();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	/**
	 * It runs the stopCollector method
	 */
	@Override
	protected void end() {
		collector.stopCollector();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	/**
	 * If the command is interrupted, It runs the stopCollector method
	 */
	@Override
	protected void interrupted() {
		collector.stopCollector();
	}
}

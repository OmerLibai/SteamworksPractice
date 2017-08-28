package org.usfirst.frc.team5951.robot.Climbing;
import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Climbing;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Contains one private object of Climbing class (climber)
 * A command that makes the robot to climb up (by using the method climbUp)
 * When the command ends or interrupted it runs the method stop 
 */
public class ClimbingUpCommand extends Command {
	private Climbing climber; 

	/**
	 * In the constructor the object climber is defined as a k_CLIMBING_SUBSYSTEM in Robot class
	 * It defines the subsystem that the comment refers to(Climbing) 
	 */
	public ClimbingUpCommand() {
		climber = Robot.k_CLIMBING_SUBSYSTEM;
		requires(climber);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	/**
	 * It runs the climbingUp method until it is told to stop
	 */
	@Override
	protected void execute() {
		climber.climbingUp();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	/**
	 * It runs the stop method
	 */
	protected void end() {
		climber.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	/**
	 * If the command is interrupted, It runs the stop method
	 */
	@Override
	protected void interrupted() {
		climber.stop();
	}
}


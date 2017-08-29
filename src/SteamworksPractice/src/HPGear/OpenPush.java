package SteamworksPractice.src.HPGear;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.HPGear;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Contains one private object of HPGear class (hpgear)
 * A command that makes the robot open the push stick (by using the method openSlide)
 */
public class OpenPush extends Command {
	private HPGear hpgear;
	/**
	 * In the constructor the object hpgear is defined as a k_HPGEAR_SUBSYSTEM in 
	 * Robot class.
	 * It defines the subsystem that the comment refers to(GPGear) 
	 */
    public OpenPush() {
        // Use requires() here to declare subsystem dependencies
    	hpgear = Robot.k_HPGEAR_SUBSYSTEM;
        requires(hpgear);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    /**
	 * It runs the openPush method until it is told to stop
	 */
    protected void execute() {
    	hpgear.openPush();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

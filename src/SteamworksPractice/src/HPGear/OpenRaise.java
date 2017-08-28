package SteamworksPractice.src.HPGear;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.HPGear;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OpenRaise extends Command {
	private HPGear hpgear;
    public OpenRaise() {
        // Use requires() here to declare subsystem dependencies
    	hpgear = Robot.k_HPGEAR_SUBSYSTEM;
         requires(hpgear);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	hpgear.openRaise();
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	HPGear.onOffSlide = true;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

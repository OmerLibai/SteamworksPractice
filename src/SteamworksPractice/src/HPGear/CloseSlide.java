package SteamworksPractice.src.HPGear;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.HPGear;

import edu.wpi.first.wpilibj.command.Command;


public class CloseSlide extends Command{
	private  HPGear hpgear;
	public CloseSlide() {
		// Use requires() here to declare subsystem dependencies
		hpgear = Robot.k_HPGEAR_SUBSYSTEM;
		requires(hpgear);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		hpgear.closeSlide();
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
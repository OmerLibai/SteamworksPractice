package SteamworksPractice.src.HPGear;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.HPGear;

import edu.wpi.first.wpilibj.command.Command;


public class OpenSlide extends Command {
	private HPGear hpgear;
	public OpenSlide() {
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
		HPGear.onOffSlide = false;
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
	}


}

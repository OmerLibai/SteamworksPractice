package SteamworksPractice.src.HPGear;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.HPGear;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ToggleSlide extends CommandGroup {
	private boolean IsSlideOpen = false;
	
	// Called just before this Command runs the first time
	protected void initalize() {
		if(IsSlideOpen) {
			addSequential(new CloseSlide() );
			IsSlideOpen = false;
		}
		else {
			addSequential(new OpenSlide());
			IsSlideOpen = true;
		}
	}
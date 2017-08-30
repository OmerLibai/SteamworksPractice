package SteamworksPractice.src.HPGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TogglePutGear extends CommandGroup {
	
	private boolean IsGearPut = false;
	//
	protected void initalize() {
		
		if(IsGearPut) {
			addSequential(new OpenRaise());
			IsGearPut= false;
		}
		else {
			addSequential(new CloseRaise());
			IsGearPut= true;		
		
		}
	
	}
}

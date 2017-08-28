package SteamworksPractice.src.HPGear;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
* A command group For the HP Gear subsystem
* It raises the gear and brings back in the piston (it is closed after the commend runs)
*/
public class GetGear extends CommandGroup {

    public GetGear() {
        // Add Commands here:
    	addSequential(new ClosePush());
    	addSequential(new WaitCommand(0.5));
        addSequential(new CloseRaise());
        // these will run in order.

        
    }
}

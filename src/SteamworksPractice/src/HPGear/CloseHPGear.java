package SteamworksPractice.src.HPGear;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
* A command group For the HP Gear subsystem
* it contains the two commands- ClosePush and CloseRaise
* between the two command there is a 0.5 milliseconds wait command
* It raises the gear and brings back in the piston (it is closed after the commend runs)
*/
public class CloseHPGear extends CommandGroup {
//was get gear
    public CloseHPGear() {
        // Add Commands here:
    	addSequential(new ClosePush());
    	addSequential(new WaitCommand(0.5));
        addSequential(new CloseRaise());
        // these will run in order.

        
    }
}

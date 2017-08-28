package SteamworksPractice.src.HPGear;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
* A command group For the HP Gear subsystem
* It releases and pushes the gear (it is open after the commend runs) 
*/
public class PutGear extends CommandGroup {

    public PutGear() {
        // Add Commands here:
         addSequential(new OpenRaise());
         addSequential(new WaitCommand(0.5));
         addSequential(new OpenPush());
        // these will run in order.

    }
}

package SteamworksPractice.src.HPGear;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
* A command group For the HP Gear subsystem
* it contains the two commands- openPush and openRaise
* between the two command there is a 0.5 milliseconds wait command
* It releases and pushes the gear (it is open after the commend runs) 
*/
public class OpenHPGear extends CommandGroup {

    public OpenHPGear() {
        // Add Commands here:
         addSequential(new OpenRaise());
         addSequential(new WaitCommand(0.5));
         addSequential(new OpenPush());
        // these will run in order.

    }
}

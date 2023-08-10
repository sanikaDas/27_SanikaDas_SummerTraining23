package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Intake;


public class ToggleRaise extends InstantCommand {
    public ToggleRaise() {
        addRequirements(Intake.getInstance());
    }
    public void initialize() {
        Intake.getInstance().toggleRaisePiston();
    }
}


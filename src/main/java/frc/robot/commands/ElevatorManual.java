package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Elevator;
import harkerrobolib.commands.IndefiniteCommand;
import harkerrobolib.util.Constants;

public class ElevatorManual extends IndefiniteCommand {

    public ElevatorManual() {
        addRequirements(Elevator.getInstance());
    }
    public void execute() {
        double speed = OI.getInstance().getDriver().getRightY();
        if (Math.abs(speed) > Constants.JOYSTICK_DEADBAND) {
            Elevator.getInstance().setElevatorPower(speed);
        }
    }
    public void end(boolean interrupted) {
        Elevator.getInstance().setElevatorPower(0);
    }
}
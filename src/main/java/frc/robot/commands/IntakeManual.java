package frc.robot.commands;

import frc.robot.OI;
import frc.robot.subsystems.Intake;
import harkerrobolib.commands.IndefiniteCommand;

public class IntakeManual extends IndefiniteCommand {
    public IntakeManual() {
        addRequirements(Intake.getInstance());
    }
    public void execute() {
        double rightTrigger = OI.getInstance().getDriver().getRightTrigger();
        double leftTrigger = OI.getInstance().getDriver().getLeftTrigger();

        if(leftTrigger > 0.5 && rightTrigger < 0.5) {
            Intake.getInstance().setOutput(0.4);
        }
        else if (leftTrigger < 0.5 && rightTrigger > 0.5) {
            Intake.getInstance().setOutput(-0.9);
        }
        else {
            Intake.getInstance().setOutput(0);
        }
    }
    public void end(boolean interrupted) {
        Intake.getInstance().setOutput(0);
    }
}
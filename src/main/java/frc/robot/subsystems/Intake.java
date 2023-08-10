package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import harkerrobolib.wrappers.HSTalon;

public class Intake extends SubsystemBase {
    private static Intake instance;

    private HSTalon intakeMaster;
    private HSTalon intakeFollower;

    private DoubleSolenoid intakePiston;
    private DoubleSolenoid raisePiston;

    private Intake() {
        intakeMaster = new HSTalon(RobotMap.Intake.MOTOR_MASTER_ID);
        intakeFollower = new HSTalon(RobotMap.Intake.MOTOR_FOLLOWER_ID);
        intakePiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 2);
        raisePiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 2);

        intakeMaster.setInverted(RobotMap.Intake.MOTOR_MASTER_INVERT);
        intakeFollower.setInverted(RobotMap.Intake.MOTOR_FOLLOWER_INVERT);

        intakeFollower.follow(intakeMaster);
    }

    public void setOutput(double power) {
        intakeMaster.set(ControlMode.PercentOutput, power);
    }

    public void toggleIntakePiston() {
        if (intakePiston.get() == Value.kOff) {
            intakePiston.set(DoubleSolenoid.Value.kReverse);
        }
        else {
            intakePiston.toggle();
        }
    }

    public void toggleRaisePiston() {
        if (raisePiston.get() == DoubleSolenoid.Value.kOff) {
            raisePiston.set(DoubleSolenoid.Value.kReverse);
        }
        else {
            raisePiston.toggle();
        }
    }

    public static Intake getInstance() {
        if(instance == null) {
            instance = new Intake();
        }
        return instance;
    }
}

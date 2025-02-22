package frc.robot.commands;

import com.stuypulse.stuylib.input.Gamepad;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

import static frc.robot.Constants.Intake.*;

/**
 * This command moves the intake based on the triggers of the operator
 */
public class IntakeDefaultCommand extends CommandBase {
    
    private final Intake intake;
    private final Gamepad operator;

    public IntakeDefaultCommand(Intake intake, Gamepad operator) {
        this.intake = intake;
        this.operator = operator;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        double value = operator.getRightTrigger() - operator.getLeftTrigger();

        if(value > CONTROLLER_DEADBAND) {
            intake.acquire();
        } else if (value < -CONTROLLER_DEADBAND) {
            intake.deacquire();
        } else {
            intake.stop();
        }
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }

}
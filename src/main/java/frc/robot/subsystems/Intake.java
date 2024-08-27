package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.IntakeConstants;


public class Intake extends SubsystemBase {
    private CANSparkMax rearMotor = new CANSparkMax(IntakeConstants.REAR_INTAKE_MOTOR_ID, MotorType.kBrushless);
    private CANSparkMax frontMotor = new CANSparkMax(IntakeConstants.FRONT_INTAKE_MOTOR_ID, MotorType.kBrushless);

    public Intake() {
        rearMotor.restoreFactoryDefaults();
        frontMotor.restoreFactoryDefaults();

    }

    public void start() {
        frontMotor.set(IntakeConstants.INTAKE_SPEED);
        rearMotor.set(IntakeConstants.INTAKE_SPEED);
    }
    
    public void stop() {
        frontMotor.set(0);
        rearMotor.set(0);
    }

    public void setSpeed(double speed) {
        frontMotor.set(0);
        rearMotor.set(0);
    }

}

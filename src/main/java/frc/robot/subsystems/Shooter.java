package frc.robot.subsystems;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.ShooterConstants;



public class Shooter extends SubsystemBase {
    CANSparkFlex topMotor = new CANSparkFlex(ShooterConstants.TOP_MOTOR_ID, MotorType.kBrushless);
    CANSparkFlex bottomMotor = new CANSparkFlex(ShooterConstants.BOTTOM_MOTOR_ID, MotorType.kBrushless);

    public Shooter() {
        topMotor.restoreFactoryDefaults();
        bottomMotor.restoreFactoryDefaults();
    }

}

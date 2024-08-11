package frc.robot.subsystems;

import java.io.File;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.constants.ControllerConstants;
import frc.robot.constants.DriveConstants;
import swervelib.SwerveDrive;
import swervelib.SwerveModule;
import swervelib.parser.SwerveParser;

public class Drivetrain {
    SwerveDrive swerveDrive;
    private boolean isFieldRelative = true;

    public Drivetrain(File configDirectory) {
        try {
            swerveDrive = new SwerveParser(configDirectory).createSwerveDrive(DriveConstants.MAX_SPEED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    

        SwerveModule[] modules = swerveDrive.getModules();

        for (SwerveModule module : modules) {
            module.getAngleMotor().factoryDefaults();
            module.getAngleMotor().setMotorBrake(true);
        }
    }

    public boolean isFieldRelative() {
        return this.isFieldRelative;
    }

    public void setFieldRelative(boolean relative) {
        this.isFieldRelative = relative;
    }

    public void zeroGyro() {
        this.swerveDrive.zeroGyro();
    }
    public Rotation2d getHeading() {
        return this.swerveDrive.getOdometryHeading();
    }
    public void setInputFromController(CommandPS5Controller driverController) {
        // Converting ControllerConstants' booleans to ints
        int xInvert = ControllerConstants.DRIVE_CONTROL_X_INVERT ? -1 : 1;
        int yInvert = ControllerConstants.DRIVE_CONTROL_Y_INVERT ? -1 : 1;
        int rotInvert = ControllerConstants.DRIVE_CONTROL_ROTATION_INVERT ? -1 : 1;


        // Deadbanding controller values
        double thetaInput = MathUtil.applyDeadband(driverController.getRightX(), ControllerConstants.CONTROLLER_DEADBAND) * DriveConstants.MAX_ROT_SPEED.getRadians();
        double xInput = MathUtil.applyDeadband(driverController.getLeftX(), ControllerConstants.CONTROLLER_DEADBAND) * DriveConstants.MAX_SPEED;
        double yInput = MathUtil.applyDeadband(driverController.getLeftY(), ControllerConstants.CONTROLLER_DEADBAND) * DriveConstants.MAX_SPEED;


        // Applying inverts from ControllerConstants
        thetaInput *= rotInvert;
        xInput *= xInvert;
        yInput = yInvert;

        // Input Squaring
        double xMagnitude = Math.copySign(xInput * xInput, xInput);
        double yMagnitude = Math.copySign(yInput * yInput, yInput);
        double angularMagnitude = Math.copySign(thetaInput * thetaInput, thetaInput);

        Translation2d translation = new Translation2d(xMagnitude,yMagnitude);

        this.drive(translation, angularMagnitude);
        
    }

    public void drive(Translation2d translation, double rotation) {
        this.swerveDrive.drive(translation, rotation, this.isFieldRelative, DriveConstants.IS_OPEN_LOOP);
    }
}

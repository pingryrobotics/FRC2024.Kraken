package frc.robot.constants;

import java.io.File;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Filesystem;

public final class DriveConstants { // TODO: GET CORRECT CONSTANTS

    public static final File CONFIG_FOLDER = new File(Filesystem.getDeployDirectory(), "swerve/");
    public static final double MAX_SPEED = Units.feetToMeters(22.8);
    
    public static final Rotation2d MAX_ROT_SPEED = Rotation2d.fromDegrees(540);
    
    public static final boolean IS_OPEN_LOOP = false;
}

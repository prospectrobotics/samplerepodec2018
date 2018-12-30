package org.usfirst.frc.team2813.subsystems.driveTrain;
import org.usfirst.frc.team2813.commands.OIDrive;
import org.usfirst.frc.team2813.robot.CreateTalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static final int LEFTTALONID = 1;
	private static final int LEFTVICTORID = 2;
	private static final int RIGHTTALONID = 7;
	private static final int RIGHTVICTORID = 8;
	private static final int PID_LOOP = 0;
	
	private final static WPI_TalonSRX driveTrainLeft = CreateTalonSRX.createDefaultWPITalonVictorSlave(LEFTTALONID, LEFTVICTORID);
	private final static WPI_TalonSRX driveTrainRight = CreateTalonSRX.createDefaultWPITalonVictorSlave(RIGHTTALONID, RIGHTVICTORID);
	
	private final DifferentialDrive robotDrive = new DifferentialDrive(driveTrainLeft, driveTrainRight);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new OIDrive());     
    }
    public static double getDistance() {
    	return (ConfigureEncoderToTalon.getDefaultDistance(driveTrainLeft, PID_LOOP) + ConfigureEncoderToTalon.getDefaultDistance(driveTrainRight, PID_LOOP))/2;
    }
    public void arcadeDrive(Joystick joystick) {
    	
    	robotDrive.arcadeDrive(joystick.getY(), -joystick.getX());
    }
    
    public void arcadeDrive(double speed) {
    	
    	robotDrive.arcadeDrive(speed, 0);
    }
}


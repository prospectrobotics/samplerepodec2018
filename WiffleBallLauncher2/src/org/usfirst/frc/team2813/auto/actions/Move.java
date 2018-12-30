package org.usfirst.frc.team2813.auto.actions;

import org.usfirst.frc.team2813.robot.Robot;
import org.usfirst.frc.team2813.subsystems.driveTrain.DriveTrain;

public class Move implements Action {

	private static boolean forward;
	private static double inches;
	private static double maxSpeed;
	
	public Move(boolean forward, double inches, double maxSpeed) {
		this.forward = forward;
		this.inches = inches;
		this.maxSpeed = maxSpeed;
	}
//	public double inchesTraveled() { FIXME uncomment when encoders are in place
//		return DriveTrain.getDistance();
//	}
	
	
	@Override
	public boolean isFinished() {
//		return inchesTraveled() >= inches; FIXME uncomment when encoders are in place
		return true;// FIXME remove when encoders are in place
	}

	@Override
	public void update() {
		Robot.driveTrain.arcadeDrive(maxSpeed);
	}

	@Override
	public void done() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	

	}



package org.usfirst.frc.team2813.auto.actions;

import org.usfirst.frc.team2813.robot.Robot;
import org.usfirst.frc.team2813.subsystems.Launcher;

import edu.wpi.first.wpilibj.Timer;

public class Spin implements Action{
	private static double time;
	
	private static final double START_TIME = 0;//FIXME shortcut - this constant should be defined correctly when coming back to this class
	
	public Spin(double time) {
		this.time = time;
		
	}
	

	@Override
	public boolean isFinished() {
		if(START_TIME - Timer.getFPGATimestamp() <= time) {
			return true;
		}
		return false;
	}

	@Override
	public void update() {
		Launcher.spinOut();
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void done() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method
		final double START_TIME = Timer.getFPGATimestamp();
	}
}
 


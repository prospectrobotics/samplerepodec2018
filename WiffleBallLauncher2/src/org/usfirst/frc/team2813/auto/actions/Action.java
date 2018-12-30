package org.usfirst.frc.team2813.auto.actions;

public interface Action {

	boolean isFinished();
	
	void update();
	
	void done();
	
	void start();
}

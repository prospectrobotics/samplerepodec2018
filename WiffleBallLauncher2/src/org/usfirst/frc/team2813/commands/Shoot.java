package org.usfirst.frc.team2813.commands;

import org.usfirst.frc.team2813.robot.Robot;
import org.usfirst.frc.team2813.subsystems.Launcher;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {
	
	public Shoot() {
		requires(Robot.launcher);
	}
	protected void execute() {
		Launcher.spinOut();
	}
	
	protected boolean isFinished() {
		return false;
		
	}
}

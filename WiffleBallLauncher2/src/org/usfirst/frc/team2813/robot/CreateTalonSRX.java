package org.usfirst.frc.team2813.robot;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class CreateTalonSRX {
	private static final int kTimeoutMs = 100;
	public static class Configuration {
		public NeutralMode NEUTRAL_MODE = NeutralMode.Brake;
		public boolean ENABLE_CURRENT_LIMIT = false;
		public boolean ENABLE_SOFT_LIMIT = false;
		public boolean ENABLE_LIMIT_SWITCH = false;
		public int FORWARD_SOFT_LIMIT = 0;
		public int REVERSE_SOFT_LIMIT = 0;
		public int PID_SLOT = 0;
		public int PID_LOOP = 0;
		public double OPEN_LOOP_RAMP_RATE = 0.0;//Time to reach set speed
		public double CLOSED_LOOP_RAMP_RATE = 0.0;
		public boolean INVERTED = false;
		public boolean SENSOR_PHASE = false;
		public FeedbackDevice FEEDBACK_SENSOR = FeedbackDevice.QuadEncoder;

	}

	private static final Configuration kDefaultConfiguration = new Configuration();

	/**
	 * Creates a WPI_TalonSRX and slaves a VictorSPX with default configuration
	 * @param talonID
	 * @param victorID
	 * @return A WPI_TalonSRX
	 */
	public static WPI_TalonSRX createDefaultWPITalonVictorSlave(int talonID, int victorID) {
		final WPI_TalonSRX talon = createWPITalon(talonID, kDefaultConfiguration);
		createPermanentSlaveVictor(victorID, talon);
		return talon;
	}

	public static void createPermanentSlaveVictor(int id, TalonSRX talon) {
		final VictorSPX victor = new VictorSPX(id);
		victor.follow(talon);
	}

	public static WPI_TalonSRX createWPITalon(int id, Configuration config) {
		WPI_TalonSRX talon = new WPI_TalonSRX(id);
		talon.set(ControlMode.PercentOutput, 0.0);

		talon.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, kTimeoutMs);
		talon.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, kTimeoutMs);
		talon.overrideLimitSwitchesEnable(config.ENABLE_LIMIT_SWITCH);

		talon.configPeakOutputForward(1.0, kTimeoutMs);
		talon.configPeakOutputReverse(-1.0, kTimeoutMs);

		talon.setNeutralMode(config.NEUTRAL_MODE);

		talon.configForwardSoftLimitThreshold(config.FORWARD_SOFT_LIMIT, kTimeoutMs);
		talon.configForwardSoftLimitEnable(config.ENABLE_SOFT_LIMIT, kTimeoutMs);

		talon.configReverseSoftLimitThreshold(config.REVERSE_SOFT_LIMIT, kTimeoutMs);
		talon.configReverseSoftLimitEnable(config.ENABLE_SOFT_LIMIT, kTimeoutMs);
		talon.overrideSoftLimitsEnable(config.ENABLE_SOFT_LIMIT);

		talon.setInverted(config.INVERTED);
		talon.setSensorPhase(config.SENSOR_PHASE);

		talon.configOpenloopRamp(config.OPEN_LOOP_RAMP_RATE, kTimeoutMs);
		talon.configClosedloopRamp(config.CLOSED_LOOP_RAMP_RATE, kTimeoutMs);
		talon.configSelectedFeedbackSensor(config.FEEDBACK_SENSOR, config.PID_LOOP, kTimeoutMs);

		talon.selectProfileSlot(config.PID_SLOT, config.PID_LOOP);

		talon.enableCurrentLimit(config.ENABLE_CURRENT_LIMIT);

		return talon;
	}
}
package org.usfirst.frc.team2813.auto;

/**
 * This class selects, runs, and stops (if necessary) a specified autonomous mode.
 * 
 * @author FRC 254
 */
public class AutoModeExecutor {
    private AutoModeBase m_auto_mode;
    private Thread m_thread = null;

    public void setAutoMode(AutoModeBase new_auto_mode) {
        m_auto_mode = new_auto_mode;
        m_thread = new Thread(new Runnable() {

			@Override
			public void run() {
				m_auto_mode.run();
			}
        });
    }

    public void start() {
        if (m_thread != null) {
            m_thread.start();
        }
    }

    public void stop() {
        if (m_auto_mode != null) {
            m_auto_mode.stop();
        }

        m_thread = null;
    }

    public AutoModeBase getAutoMode() {
        return m_auto_mode;
    }
}

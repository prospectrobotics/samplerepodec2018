package org.usfirst.frc.team2813.auto;

import org.usfirst.frc.team2813.auto.actions.Action;
import edu.wpi.first.wpilibj.DriverStation;

/**
 * An abstract class that is the basis of the robot's autonomous routines. This is implemented in auto modes (which are
 * routines that do actions).
 * 
 * @author FRC 254
 */
public abstract class AutoModeBase {
    protected double mUpdateRate = 1.0 / 50.0;
    protected boolean mActive = false;


    public void run() {
        mActive = true;

        
        done();
    }

    public void done() {
        System.out.println("Auto mode done");
    }

    public void stop() {
        mActive = false;
    }

    public boolean isActive() {
        return mActive;
    }

    public boolean isActiveWithThrow(){

        return isActive();
    }

    public void runAction(Action action) {
        action.start();

        while (!action.isFinished()) {
            action.update();
            long waitTime = (long) (mUpdateRate * 1000.0);

            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        action.done();
    }
}
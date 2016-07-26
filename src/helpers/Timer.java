package helpers;

/**
 * Project: TaskMan
 * <p>
 * Date: 26 Tem 2016
 * Author: Tarık İNCE <incetarik@hotmail.com>
 */

import java.util.Date;
import java.util.TimerTask;

/**
 * The Timer class should be used forms.Application-Wide for scheduling events.
 * All functions returns the class itself. Thus, calls are chainable.
 */
public class Timer {
    private java.util.Timer timer;

    public Timer() {
        timer = new java.util.Timer();
    }

    public Timer addRepeating(long periodInMs, Runnable task) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                task.run();
            }
        }, 0, periodInMs);

        return this;
    }

    public Timer addDelayed(long delay, Runnable task) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                task.run();
            }
        }, delay);

        return this;
    }

    public Timer addScheduled(Date date, Runnable task) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                task.run();
            }
        }, date);

        return this;
    }
}

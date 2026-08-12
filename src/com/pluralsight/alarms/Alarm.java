package com.pluralsight.alarms;

import java.time.LocalDateTime;
import java.awt.Color;

public abstract class Alarm implements Widget, PersistentObject {
    protected final String message;
    protected boolean isActive;
    private LocalDateTime snoozeUntil;

    Alarm(String message) {
        this.message = message;
    }

    @Override
    public String getHelpText() {
        return "I'm an alarm. You can turn me on or off.";
    }

    @Override
    public void save() {
        System.out.println("Saving...");
    }


    public abstract Color getColor();

    public void snooze() {
        if(isActive) {
            snoozeUntil = LocalDateTime.now().plusHours(2);
        }
    }

    public boolean isSnoozing() {
        return snoozeUntil.isAfter(LocalDateTime.now());
    }

    void stopSnoozing() {
        snoozeUntil = LocalDateTime.now().minusSeconds(1);
    }

    public void turnOn() {
        this.isActive = true;
        stopSnoozing();
    }

    public void turnOff() {
        this.isActive = false;
        stopSnoozing();
    }

    public String getReport() {
        return getReport(false);
    }

    public String getReport(boolean upperCase) {
        if(isActive && !isSnoozing()) {
            if(upperCase) {
                return message.toUpperCase();
            } else {
                return message;
            }
        } else {
            return " ";
        }
    }

    public abstract boolean isUrgent();

    public void sendReport() {
        System.out.println(getReport(true));
    }
}

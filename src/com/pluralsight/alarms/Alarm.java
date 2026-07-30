package com.pluralsight.alarms;

import java.time.LocalDateTime;

public class Alarm {
    protected final String message;
    protected boolean isActive;
    private LocalDateTime snoozeUntil;

    Alarm(String message) {
        this.message = message;
    }

    public void snooze() {
        if(isActive) {
            snoozeUntil = LocalDateTime.now().plusSeconds(5);
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

    public void sendReport() {
        System.out.println(getReport(true));
    }
}

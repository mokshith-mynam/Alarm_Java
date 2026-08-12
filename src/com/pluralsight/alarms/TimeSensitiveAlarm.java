package com.pluralsight.alarms;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeSensitiveAlarm extends Alarm {
    private final LocalDateTime creationTime;

    public TimeSensitiveAlarm(String message) {
        super(message);
        this.creationTime = LocalDateTime.now();
    }

    @Override
    public Color getColor() {
        return Color.MAGENTA;
    }

    @Override
    public String getReport(boolean upperCase) {
        String report = super.getReport(true);
        if(report.isEmpty()) {
            return report;
        }
        else {
            return LocalTime.now() + ": " + report;
        }
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    @Override
    public boolean isUrgent() {
        LocalDateTime oneHourAge = LocalDateTime.now().minusHours(1);
        return getCreationTime().isAfter(oneHourAge);
    }
}

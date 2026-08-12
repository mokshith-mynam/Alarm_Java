package com.pluralsight.alarms;

import java.awt.*;

public class PriorityAlarm extends Alarm {
    private final int priority;

    public PriorityAlarm(String message, int priority) {
        super(message);
        this.priority = priority;
    }

    public Color getColor() {
        return Color.GREEN;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public boolean isUrgent() {
        return getPriority() > 2;
    }
}

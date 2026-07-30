package com.pluralsight.alarms;
public class PriorityAlarm extends Alarm{
    private final int priority;

    public PriorityAlarm(String message, int priority) {
        super(message);
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}

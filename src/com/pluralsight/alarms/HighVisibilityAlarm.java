package com.pluralsight.alarms;

public class HighVisibilityAlarm extends Alarm{

    public HighVisibilityAlarm(String message) {
        super(message);
    }

    @Override
    public String getReport(boolean upperCase) {
        String report = super.getReport(upperCase);
        if(report.isEmpty()) {
            return report;
        }
        else {
            return report + "!";
        }
    }
}

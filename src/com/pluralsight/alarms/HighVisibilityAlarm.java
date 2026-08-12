package com.pluralsight.alarms;

import java.awt.*;

public class HighVisibilityAlarm extends Alarm{

    public HighVisibilityAlarm(String message) {
        super(message);
    }

    @Override
    public Color getColor() {
       return Color.ORANGE;
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

    @Override
    public boolean isUrgent() {
        return true;
    }
}

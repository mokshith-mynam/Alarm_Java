package com.pluralsight.alarms;

public class Application {
    static void main() {
        Dashboard dashboard = new Dashboard();
        dashboard.add(new HighVisibilityAlarm("Temperature Too high"));
        dashboard.add(new PriorityAlarm("Pressure too low", 41));
        dashboard.add(new Alarm("Temperature too high."));
        dashboard.add(new TimeSensitiveAlarm("Temperature Too High"));

        dashboard.printBigReport();
    }
}
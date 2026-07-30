package com.pluralsight.alarms;

public class Application {
    static void main() {
        HighVisibilityAlarm alarm1 = new HighVisibilityAlarm("Temperature too high!");
        alarm1.turnOn();
        alarm1.sendReport();
    }
}

package com.pluralsight.alarms;

import java.time.LocalDateTime;

public class Application {
    static void main() {
        HighVisibilityAlarm alarm = new HighVisibilityAlarm("Temperature too high");
        // Testing the activate function.
        activate(alarm);
        // Similarly testing printHelpText() and saveItTwice().
        printHelpText(alarm);
        saveItTwice(alarm);
        // Getting the color of the alarm.
        System.out.println(alarm.getColor());

        // Upcasted alarm cannot access methods of inherited alarm.
        Alarm alarm1 = new PriorityAlarm("Hey this is an upcasted priority alarm", 44);
        // Here alarm2 can access the methods of both classes. (Ex. getPriority());
        PriorityAlarm alarm2 = new PriorityAlarm("Hey this is a priority alarm.", 21);
        System.out.println(alarm2.getPriority());
        TimeSensitiveAlarm alarm3 = new TimeSensitiveAlarm("This is a time sensitivity alarm.");
        alarm3.snooze(); // Snooze time has been set for 2 hours.
        System.out.println("Testing whether alarm3 is urgent: "+alarm3.isUrgent());

        /* Adding all the alarms to the dashboard for printing them in a Big Report
         which makes all the messages to uppercase. */
        Dashboard dashboard = new Dashboard();
        dashboard.add(alarm1);
        dashboard.add(alarm2);
        dashboard.add(alarm3);

        dashboard.printBigReport();

    }

    private static void activate(HighVisibilityAlarm alarm) {
        alarm.turnOn();
    }

    // Accessing the interface 'Widget'. It calls the implemented method in "Alarm" class.
    public static void printHelpText(Widget widget) {
        System.out.println(widget.getHelpText());
    }

    // This is also similar to 'printHelpText' method. It calls the implemented method in "Alarm" class.
    public static void saveItTwice(PersistentObject persistentObject) {
        persistentObject.save();
        persistentObject.save();
    }

}
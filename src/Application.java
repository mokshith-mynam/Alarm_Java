public class Application {
    static void main() {
        Alarm alarm = new Alarm("Temperature too high!");
        alarm.turnOn();
        alarm.snooze();
    }
}

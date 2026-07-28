import java.time.LocalDateTime;
import java.util.Locale;

public class Alarm {
    String message;
    boolean isActive;
    LocalDateTime snoozeUntil;

    Alarm(String message) {
        this.message = message;
    }

    void snooze() {
        if(isActive) {
            snoozeUntil = LocalDateTime.now().plusSeconds(5);
        }
    }

    boolean isSnoozing() {
        return LocalDateTime.now().isAfter(snoozeUntil);
    }

    void stopSnoozing() {
        snoozeUntil = LocalDateTime.now().minusSeconds(1);
    }

    void turnOn() {
        this.isActive = true;
        stopSnoozing();
    }

    void turnOff() {
        this.isActive = false;
        stopSnoozing();
    }

    String getReport() {
        return getReport(false);
    }

    String getReport(boolean upperCase) {
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

    String sendReport() {
        return getReport(true);
    }
}

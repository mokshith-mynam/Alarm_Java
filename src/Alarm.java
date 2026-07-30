import java.time.LocalDateTime;
import java.util.Locale;

public class Alarm {
    private String message;
    private boolean isActive;
    private LocalDateTime snoozeUntil;

    Alarm(String message) {
        this.message = message;
    }

    public void snooze() {
        if(isActive) {
            snoozeUntil = LocalDateTime.now().plusSeconds(5);
        }
    }

    public boolean isSnoozing() {
        return LocalDateTime.now().isAfter(snoozeUntil);
    }

    void stopSnoozing() {
        snoozeUntil = LocalDateTime.now().minusSeconds(1);
    }

    public void turnOn() {
        this.isActive = true;
        stopSnoozing();
    }

    public void turnOff() {
        this.isActive = false;
        stopSnoozing();
    }

    public String getReport() {
        return getReport(false);
    }

    private String getReport(boolean upperCase) {
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

    public String sendReport() {
        return getReport(true);
    }
}

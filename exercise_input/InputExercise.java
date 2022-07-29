package exercise_input;

import java.text.*;
import java.util.*;

import static java.lang.String.*;
import static java.lang.System.*;
import static java.util.TimeZone.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class InputExercise {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Input Exersice");
        // content
        run();
    }

    // Fields
    private static final double MIN_TIMEZONE = -11;
    private static final double MAX_TIMEZONE = 12;

    // Main
    private static void run() {
        // cap
        out.println();
        printAdv(GREEN, "Nhập vào múi giờ: ", RESET);
        // format
        var timeFormat = new SimpleDateFormat("HH:mm:ss");
        timeFormat.setTimeZone(getTimeZone(numToUTC(timezoneLimit(MIN_TIMEZONE, MAX_TIMEZONE))));
        // output
        printlnAdv(YELLOW, format("Hiện giờ là: %s", timeFormat.format(new Date())));
        out.println();
        // ctrl
        checkOut();
    }

    // Timezone limit
    private static double timezoneLimit(double min, double max) {
        var n = scanDub();
        if (n < min || n > max) {
            // min +-
            var iMin = valueOf((int) min);
            var sMin = valueOf(min);
            // max +-
            var iMax = valueOf((int) max);
            var sMax = valueOf(max);
            // main
            printAdv(RED,
                    format("Múi giờ từ GMT%s đến GMT%s, xin nhập lại: ",
                            min == (int) min ? min > 0 ? "+" + iMin : iMin : min > 0 ? "+" + sMin : sMin,
                            max == (int) max ? max > 0 ? "+" + iMax : iMax : max > 0 ? "+" + sMax : sMax),
                    RESET);
            n = timezoneLimit(min, max);
        }
        return n;
    }

    // Convert number to UTC
    private static String numToUTC(double n) {
        var hour = (int) n;
        var minute = (int) ((n - hour) * 60);
        return format("%s%d:%02d", n < 0 ? "GMT-" : "GMT+", hour, minute);
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

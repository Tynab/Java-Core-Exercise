package exercise_input;

import java.text.*;
import java.util.*;

import static java.lang.String.*;
import static java.lang.System.*;
import static java.util.TimeZone.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class InputExercise {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        PrintlnAdv("Input Exersice");
        // content
        Main();
    }

    // Fields
    private static final double _min_timezone = -11;
    private static final double _max_timezone = 12;

    // Main
    private static void Main() {
        // cap
        out.println();
        PrintAdv(GREEN, "Nhập vào múi giờ: ", RESET);
        // format
        var timeFormat = new SimpleDateFormat("HH:mm:ss");
        timeFormat.setTimeZone(getTimeZone(NumToUTC(TimezoneLimit(_min_timezone, _max_timezone))));
        // output
        PrintlnAdv(YELLOW, format("Hiện giờ là: %s", timeFormat.format(new Date())));
        out.println();
        // ctrl
        CheckOut();
    }

    // Timezone limit
    private static double TimezoneLimit(double min, double max) {
        var n = ScanDub();
        if (n < min || n > max) {
            // min +-
            var iMin = valueOf((int) min);
            var sMin = valueOf(min);
            // max +-
            var iMax = valueOf((int) max);
            var sMax = valueOf(max);
            // main
            PrintAdv(RED,
                    format("Múi giờ từ GMT%s đến GMT%s, xin nhập lại: ",
                            min == (int) min ? min > 0 ? "+" + iMin : iMin : min > 0 ? "+" + sMin : sMin,
                            max == (int) max ? max > 0 ? "+" + iMax : iMax : max > 0 ? "+" + sMax : sMax),
                    RESET);
            n = TimezoneLimit(min, max);
        }
        return n;
    }

    // Convert number to UTC
    private static String NumToUTC(double n) {
        var hour = (int) n;
        var minute = (int) ((n - hour) * 60);
        return format("%s%d:%02d", n < 0 ? "GMT-" : "GMT+", hour, minute);
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

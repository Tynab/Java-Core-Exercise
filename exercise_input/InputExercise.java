package exercise_input;

import java.util.Date;
import java.text.SimpleDateFormat;

import static java.lang.String.*;
import static java.lang.System.*;
import static java.util.TimeZone.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class InputExercise {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(CYAN_BOLD, "Input Exersice");
        // content
        Main();
    }

    // Main
    private static void Main() {
        // cap
        out.println();
        PrintAdv(GREEN, "Nhập vào múi giờ: ", RESET);
        // format
        var timeFormat = new SimpleDateFormat("HH:mm:ss");
        timeFormat.setTimeZone(getTimeZone(NumToUTC(TimezoneLimit(-11, 12))));
        // output
        PrintlnAdv(YELLOW, format("Hiện giờ là: %s\n", timeFormat.format(new Date())));
        // ctrl
        CheckOut();
    }

    // Timezone limit
    private static float TimezoneLimit(float min, float max) {
        var n = ScanFloat();
        if (n < min || n > max) {
            PrintAdv(RED, "Múi giờ từ GMT-11 đến GMT+12, xin nhập lại: ", RESET);
            n = TimezoneLimit(min, max);
        }
        return n;
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

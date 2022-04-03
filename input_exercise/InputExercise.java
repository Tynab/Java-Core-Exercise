package input_exercise;

import java.util.Date;
import java.text.SimpleDateFormat;

import static java.lang.String.*;
import static java.lang.System.*;
import static java.util.TimeZone.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class InputExercise {
    public static void main(String[] args) {
        out.println();
        PrintlnAdv(BLUE_BOLD, "Input Exersice");
        Main();
    }

    // Main
    private static void Main() {
        out.println();
        PrintAdv(GREEN, "Nhập vào múi giờ: ", YELLOW);
        var time_zone = CheckLimitFloat(-11, 12);
        var time_format = new SimpleDateFormat("HH:mm:ss");
        time_format.setTimeZone(getTimeZone(NumToUTC(time_zone)));
        var result = format("Hiện giờ là: %s.\n", time_format.format(new Date()));
        PrintlnAdv(CYAN, result);
        CheckOut();
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

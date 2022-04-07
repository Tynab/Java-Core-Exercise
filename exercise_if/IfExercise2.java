package exercise_if;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class IfExercise2 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        PrintlnAdv("If Exersice 2");
        // content
        Main();
    }

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(GREEN, "Nhập vào số tự nhiên: ", RESET);
        var n = NumLimit(0, MAX_VALUE);
        // output
        PrintlnAdv(YELLOW, format("Số %d có %d chữ số.", n, NumCounter(n)));
        out.println();
        // ctrl
        CheckOut();
    }

    // Number counter
    private static int NumCounter(int n) {
        return String.valueOf(n).length();
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

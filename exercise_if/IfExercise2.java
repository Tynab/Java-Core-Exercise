package exercise_if;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class IfExercise2 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("If Exersice 2");
        // content
        run();
    }

    // Main
    private static void run() {
        // input
        out.println();
        printAdv(GREEN, "Nhập vào số tự nhiên: ", RESET);
        var n = numLimit(0, MAX_VALUE);
        // output
        printlnAdv(YELLOW, format("Số %d có %d chữ số.", n, numCounter(n)));
        out.println();
        // ctrl
        checkOut();
    }

    // Number counter
    private static int numCounter(int n) {
        return String.valueOf(n).length();
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

package exercise_loop;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class LoopExercise {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        PrintlnAdv("Loop Exersice");
        // content
        Main();
    }

    // Main
    private static void Main() {
        // cap
        out.println();
        PrintAdv(GREEN, "Nhập vào số nguyên dương: ", RESET);
        // output
        PrintlnAdv(YELLOW, format("Kết quả biểu thức là: %s", WritePerfectDub(Calculator(NumLimit(1, MAX_VALUE)))));
        out.println();
        // ctrl
        CheckOut();
    }

    // Calculator
    private static double Calculator(int n) {
        var sum = 0d;
        for (var i = 1; i <= n; i++) {
            sum += (double) 1 / (i * (i + 1) * (i + 2));
        }
        return sum;
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

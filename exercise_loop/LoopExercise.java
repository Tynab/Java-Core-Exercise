package exercise_loop;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class LoopExercise {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Loop Exersice");
        // content
        run();
    }

    // Main
    private static void run() {
        // cap
        out.println();
        printAdv(GREEN, "Nhập vào số nguyên dương: ", RESET);
        // output
        printlnAdv(YELLOW, format("Kết quả biểu thức là: %s", writePerfectDub(calculator(numLimit(1, MAX_VALUE)))));
        out.println();
        // ctrl
        checkOut();
    }

    // Calculator
    private static double calculator(int n) {
        var sum = 0d;
        for (var i = 1; i <= n; i++) {
            sum += (double) 1 / (i * (i + 1) * (i + 2));
        }
        return sum;
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

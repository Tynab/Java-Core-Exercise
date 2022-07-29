package exercise_if;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class IfExercise1 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("If Exersice 1");
        // content
        run();
    }

    // Fields
    private static final int N_MAX = 3;

    // Main
    private static void run() {
        // input
        out.println();
        var ns = new int[N_MAX];
        for (var i = 0; i < N_MAX; i++) {
            printAdv(GREEN, format("Nhập số tự nhiên thứ %d: ", i + 1), RESET);
            ns[i] = numLimit(0, MAX_VALUE);
        }
        // output
        printlnAdv(YELLOW, format("Kết luận: %s.", checkOrder(ns)));
        out.println();
        // ctrl
        checkOut();
    }

    // Check ascending
    private static boolean isAscending(int... args) {
        var isSuccess = true;
        for (var i = 0; i < args.length - 1; i++) {
            if (args[i] > args[i + 1]) {
                isSuccess = false;
                break;
            }
        }
        return isSuccess;
    }

    // Check descending
    private static boolean isDescending(int... args) {
        var isSuccess = true;
        for (var i = 0; i < args.length - 1; i++) {
            if (args[i] < args[i + 1]) {
                isSuccess = false;
                break;
            }
        }
        return isSuccess;
    }

    // Check order
    private static String checkOrder(int... args) {
        return isAscending(args) ? "xếp theo thứ tự tăng dần"
                : isDescending(args) ? "xếp theo thứ tự giảm dần" : "chưa được sắp xếp";
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

package exercise_array;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class ArrayExercise {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Array Exersice");
        // content
        run();
    }

    // Fields
    private static final int N_MAX = 10;

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
        out.print(YELLOW);
        checkMirror(ns);
        out.println();
        // ctrl
        checkOut();
    }

    // Check mirror
    private static void checkMirror(int... args) {
        // pick
        var isSuccess = false;
        var max = args.length;
        for (var i = 0; i < max / 2; i++) {
            if (args[i] == args[max - 1 - i]) {
                isSuccess = true;
                printlnAdv(format("Số %d đối xứng ở cặp vị trí %d và %d.", args[i], i + 1, max - i));
            }
        }
        // check back
        if (!isSuccess) {
            printlnAdv("Không có cặp số đối xứng nào.");
        }
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

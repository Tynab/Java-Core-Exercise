package exercise_array;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class ArrayExercise {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(BLUE_BOLD, "Array Exersice");
        // content
        Main();
    }

    // Fields
    private static final int _nMax = 10;

    // Main
    private static void Main() {
        // input
        var ns = new int[_nMax];
        out.println();
        for (var i = 0; i < _nMax; i++) {
            PrintAdv(GREEN, format("Nhập số tự nhiên thứ %d: ", i + 1), RESET);
            ns[i] = NumLimit(0, MAX_VALUE);
        }
        // output
        out.print(YELLOW);
        CheckMirror(ns);
        // ctrl
        CheckOut();
    }

    // Check mirror
    private static void CheckMirror(int... args) {
        // pick
        var is_success = false;
        var max = args.length;
        for (var i = 0; i < max / 2; i++) {
            if (args[i] == args[max - 1 - i]) {
                is_success = true;
                PrintlnAdv(format("Số %d đối xứng ở cặp vị trí %d và %d.", args[i], i + 1, max - i));
            }
        }
        // check back
        if (!is_success) {
            PrintlnAdv("Không có cặp số đối xứng nào.");
        }
        out.println();
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

package exercise_if;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class IfExercise1 {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(BLUE_BOLD, "If Exersice 1");
        // content
        Main();
    }

    // Fields
    private static final int _nMax = 3;

    // Main
    private static void Main() {
        // var
        var ns = new int[_nMax];
        // input
        out.println();
        for (var i = 0; i < _nMax; i++) {
            PrintAdv(GREEN, format("Nhập số tự nhiên thứ %d: ", i + 1), RESET);
            ns[i] = NumLimit(0, MAX_VALUE);
        }
        // output
        PrintlnAdv(YELLOW, format("Kết luận: %s.\n", CheckOrder(ns)));
        // ctrl
        CheckOut();
    }

    // Check ascending
    private static boolean IsAscending(int... args) {
        var is_success = true;
        for (var i = 0; i < args.length - 1; i++) {
            if (args[i] > args[i + 1]) {
                is_success = false;
                break;
            }
        }
        return is_success;
    }

    // Check descending
    private static boolean IsDescending(int... args) {
        var is_success = true;
        for (var i = 0; i < args.length - 1; i++) {
            if (args[i] < args[i + 1]) {
                is_success = false;
                break;
            }
        }
        return is_success;
    }

    // Check order
    private static String CheckOrder(int... args) {
        return IsAscending(args) ? "xếp theo thứ tự tăng dần"
                : IsDescending(args) ? "xếp theo thứ tự giảm dần" : "chưa được sắp xếp";
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

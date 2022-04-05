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

    // Main
    private static void Main() {
        // var
        var nMax = 3;
        var ns = new int[nMax];
        // input
        out.println();
        for (var i = 0; i < nMax; i++) {
            PrintAdv(GREEN, format("Nhập số tự nhiên thứ %d: ", i + 1), RESET);
            ns[i] = NumLimit(0, MAX_VALUE);
        }
        // output
        PrintlnAdv(YELLOW, format("Kết luận: %s.\n", CheckOrder(ns)));
        // ctrl
        CheckOut();
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

package bai_tap_nop;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaitapJava10 {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(BLUE_BOLD, "Bài Tập Java 10");
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
        PrintlnAdv(YELLOW, format("Tổng các từ 1 đến %d là: %d\n", n, SumLim(n)));
        // ctrl
        CheckOut();
    }

    // Sum lim
    private static int SumLim(int n) {
        var sum = 0;
        for (var i = 1; i <= n; i++) {
            sum += i;
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

package bai_tap_nop;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;

import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava7 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        PrintlnAdv("Bài Tập Java 7");
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
        PrintlnAdv(YELLOW, format("Các ước số của %d là: %s", n, DivisorList(n)));
        out.println();
        // ctrl
        CheckOut();
    }

    // Divisor list
    private static String DivisorList(int n) {
        var s = "";
        for (var i = 1; i <= n; i++) {
            if (n % i == 0) {
                s += format(", %d", i);
            }
        }
        return s.substring(2);
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

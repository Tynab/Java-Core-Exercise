package bai_tap_nop;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava7 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 7");
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
        printlnAdv(YELLOW, format("Các ước số của %d là: %s", n, divisorList(n)));
        out.println();
        // ctrl
        checkOut();
    }

    // Divisor list
    private static String divisorList(int n) {
        var s = "";
        for (var i = 1; i <= n; i++) {
            if (n % i == 0) {
                s += format(", %d", i);
            }
        }
        return s.substring(2);
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

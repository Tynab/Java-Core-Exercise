package bai_tap_nop;

import static java.lang.Integer.*;
import static java.lang.Math.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava11 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 11");
        // content
        run();
    }

    // Main
    private static void run() {
        // input
        out.println();
        printAdv(GREEN, "Nhập vào số nguyên dương: ", RESET);
        var n = numLimit(1, MAX_VALUE);
        // output
        printlnAdv(YELLOW, format("Số lớn nhất nhỏ hơn log2(%d) là: %d", n, maxLimLog2(n)));
        out.println();
        // ctrl
        checkOut();
    }

    // Max lim log2
    private static int maxLimLog2(int n) {
        var max = 0;
        var log = log(n) / log(2); // pin out loop
        for (var i = 1; i <= n; i++) {
            if (i < log) {
                max = i;
            } else {
                break;
            }
        }
        return max;
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

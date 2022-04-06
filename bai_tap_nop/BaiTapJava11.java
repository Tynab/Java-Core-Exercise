package bai_tap_nop;

import static java.lang.Integer.*;
import static java.lang.Math.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava11 {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(BLUE_BOLD, "Bài Tập Java 11");
        // content
        Main();
    }

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(GREEN, "Nhập vào số tự nhiên N*: ", RESET);
        var n = NumLimit(1, MAX_VALUE);
        // output
        PrintlnAdv(YELLOW, format("Số lớn nhất nhỏ hơn log2(%d) là: %d\n", n, MaxLimLog2(n)));
        // ctrl
        CheckOut();
    }

    // Max lim log2
    private static int MaxLimLog2(int n) {
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
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

package bai_tap_nop;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;

import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava4 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        PrintlnAdv("Bài Tập Java 4");
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
        PrintlnAdv(YELLOW, format("Tổng các chữ số của %d là: %d", n, SumMe(n)));
        out.println();
        // ctrl
        CheckOut();
    }

    // Sum me
    private static int SumMe(int n) {
        var sum = 0;
        var num = String.valueOf(n);
        for (var i = 0; i < num.length(); i++) {
            sum += ParseIntAdv(num.charAt(i));
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

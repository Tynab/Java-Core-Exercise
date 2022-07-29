package bai_tap_nop;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava4 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 4");
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
        printlnAdv(YELLOW, format("Tổng các chữ số của %d là: %d", n, sumMe(n)));
        out.println();
        // ctrl
        checkOut();
    }

    // Sum me
    private static int sumMe(int n) {
        var sum = 0;
        var num = String.valueOf(n);
        for (var i = 0; i < num.length(); i++) {
            sum += parseIntAdv(num.charAt(i));
        }
        return sum;
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

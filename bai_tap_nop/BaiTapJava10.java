package bai_tap_nop;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava10 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 10");
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
        printlnAdv(YELLOW, format("Tổng các từ 1 đến %d là: %d", n, sumLim(n)));
        out.println();
        // ctrl
        checkOut();
    }

    // Sum lim
    private static int sumLim(int n) {
        var sum = 0;
        for (var i = 1; i <= n; i++) {
            sum += i;
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

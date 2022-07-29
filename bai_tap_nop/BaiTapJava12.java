package bai_tap_nop;

import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava12 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 12");
        // content
        run();
    }

    // Fields
    private static final int MIN = 1;
    private static final int MAX = 9;

    // Main
    private static void run() {
        // input
        out.println();
        printAdv(GREEN, format("Nhập vào số từ %d đến %d: ", MIN, MAX), RESET);
        // output
        drawStar(numLimit(MIN, MAX));
        out.println();
        // ctrl
        checkOut();
    }

    // Drawing star
    private static void drawStar(int n) {
        out.print(YELLOW);
        for (var i = 1; i <= n; i++) {
            var s = "";
            for (var j = 1; j <= n; j++) {
                s += j <= i ? valueOf(j) : " ";
            }
            printlnAdv(s);
        }
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

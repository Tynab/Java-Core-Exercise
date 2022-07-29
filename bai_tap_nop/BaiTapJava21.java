package bai_tap_nop;

import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava21 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 21");
        // content
        run();
    }

    // Main
    private static void run() {
        // input
        out.println();
        printAdv(CYAN, "Nhập thông tin của kangaroo 1");
        out.println();
        printAdv(GREEN, "Vị trí (0 <= x1 < 10000): x1 = ", RESET);
        var x1 = numLimit(0, 9999);
        printAdv(GREEN, "Vận tốc (1 <= v1 <= 10000): v1 = ", RESET);
        var v1 = numLimit(1d, 10000d);
        printAdv(CYAN, "Nhập thông tin của kangaroo 2");
        out.println();
        printAdv(GREEN, "Vị trí (x1 < x2 < 10000): x2 = ", RESET);
        var x2 = numLimit(x1, 10000);
        printAdv(GREEN, "Vận tốc (1 <= v2 <= 10000): v2 = ", RESET);
        var v2 = numLimit(1d, 10000d);
        // output
        out.print(YELLOW);
        handle(x1, v1, x2, v2);
        out.println();
        // ctrl
        checkOut();
    }

    // Handle
    private static void handle(int x1, double v1, int x2, double v2) {
        if (v1 > v2) {
            printlnAdv("2 con kangaroo có thể gặp nhau.");
            printAdv(format("Vị trí 2 con kangaroo gặp nhau là: %s",
                    writePerfectDub((double) v1 * (x2 - x1) / (v1 - v2))));
        } else {
            printlnAdv("2 con kangaroo không thể gặp nhau.");
        }
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

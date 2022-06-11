package bai_tap_nop;

import static java.lang.String.*;
import static java.lang.System.*;

import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava21 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        PrintlnAdv("Bài Tập Java 21");
        // content
        Main();
    }

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(CYAN, "Nhập thông tin của kangaroo 1");
        out.println();
        PrintAdv(GREEN, "Vị trí (0 <= x1 < 10000): x1 = ", RESET);
        var x1 = NumLimit(0, 9999);
        PrintAdv(GREEN, "Vận tốc (1 <= v1 <= 10000): v1 = ", RESET);
        var v1 = NumLimit(1d, 10000d);
        PrintAdv(CYAN, "Nhập thông tin của kangaroo 2");
        out.println();
        PrintAdv(GREEN, "Vị trí (x1 < x2 < 10000): x2 = ", RESET);
        var x2 = NumLimit(x1, 10000);
        PrintAdv(GREEN, "Vận tốc (1 <= v2 <= 10000): v2 = ", RESET);
        var v2 = NumLimit(1d, 10000d);
        // output
        out.print(YELLOW);
        Handle(x1, v1, x2, v2);
        out.println();
        // ctrl
        CheckOut();
    }

    // Handle
    private static void Handle(int x1, double v1, int x2, double v2) {
        if (v1 > v2) {
            PrintlnAdv("2 con kangaroo có thể gặp nhau.");
            PrintAdv(format("Vị trí 2 con kangaroo gặp nhau là: %s",
                    WritePerfectDub((double) v1 * (x2 - x1) / (v1 - v2))));
        } else {
            PrintlnAdv("2 con kangaroo không thể gặp nhau.");
        }
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

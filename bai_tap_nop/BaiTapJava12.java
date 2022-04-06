package bai_tap_nop;

import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava12 {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(BLUE_BOLD, "Bài Tập Java 12");
        // content
        Main();
    }

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(GREEN, "Nhập vào số từ 1 đến 9: ", RESET);
        // output
        out.print(YELLOW);
        DrawStar(NumLimit(1, 9));
        PrintAdv(RESET, "\n");
        // ctrl
        CheckOut();
    }

    // Drawing star
    private static void DrawStar(int n) {
        for (var i = 1; i <= n; i++) {
            var s = "";
            for (var j = 1; j <= n; j++) {
                s += j <= i ? valueOf(j) : " ";
            }
            PrintlnAdv(s);
        }
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

package bai_tap_nop;

import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava12 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        PrintlnAdv("Bài Tập Java 12");
        // content
        Main();
    }

    // Fields
    private static final int _min = 1;
    private static final int _max = 9;

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(GREEN, format("Nhập vào số từ %d đến %d: ", _min, _max), RESET);
        // output
        DrawStar(NumLimit(_min, _max));
        out.println();
        // ctrl
        CheckOut();
    }

    // Drawing star
    private static void DrawStar(int n) {
        out.print(YELLOW);
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

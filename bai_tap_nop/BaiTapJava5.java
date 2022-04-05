package bai_tap_nop;

import static java.lang.Integer.*;
import static java.lang.Math.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava5 {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(BLUE_BOLD, "Bài Tập Java 5");
        // content
        Main();
    }

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(CYAN, "Nhập tọa độ điểm A\n");
        PrintAdv(GREEN, "xA = ", RESET);
        var xA = NumLimit(MIN_VALUE, MAX_VALUE);
        PrintAdv(GREEN, "yA = ", RESET);
        var yA = NumLimit(MIN_VALUE, MAX_VALUE);
        PrintAdv(CYAN, "Nhập tọa độ điểm B\n");
        PrintAdv(GREEN, "xB = ", RESET);
        var xB = NumLimit(MIN_VALUE, MAX_VALUE);
        PrintAdv(GREEN, "yB = ", RESET);
        var yB = NumLimit(MIN_VALUE, MAX_VALUE);
        // output
        var d = Length(xA, yA, xB, yB);
        if (d == (int) d) {
            PrintlnAdv(YELLOW, format("Độ dài đoạn thằng AB là: %d\n", (int) d));
        } else {
            PrintlnAdv(YELLOW, format("Độ dài đoạn thằng AB là: %s\n", d));
        }
        // ctrl
        CheckOut();
    }

    // Sum me
    private static double Length(int x1, int y1, int x2, int y2) {
        return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

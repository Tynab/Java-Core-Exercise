package bai_tap_nop;

import static java.lang.Math.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava5 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        PrintlnAdv("Bài Tập Java 5");
        // content
        Main();
    }

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(CYAN, "Nhập tọa độ điểm A");
        out.println();
        PrintAdv(GREEN, "xA = ", RESET);
        var xA = ScanInt();
        PrintAdv(GREEN, "yA = ", RESET);
        var yA = ScanInt();
        PrintAdv(CYAN, "Nhập tọa độ điểm B");
        out.println();
        PrintAdv(GREEN, "xB = ", RESET);
        var xB = ScanInt();
        PrintAdv(GREEN, "yB = ", RESET);
        var yB = ScanInt();
        // output
        PrintlnAdv(YELLOW, format("Độ dài đoạn thằng AB là: %s", WritePerfectDub(Length(xA, yA, xB, yB))));
        out.println();
        // ctrl
        CheckOut();
    }

    // Length AB
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

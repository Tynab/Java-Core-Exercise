package bai_tap_nop;

import static java.lang.Math.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava19 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        PrintlnAdv("Bài Tập Java 19");
        // content
        Main();
    }

    // Main
    private static void Main() {
        // cap
        out.println(CYAN);
        PrintlnAdv("1. Giải phương trình bậc 1");
        PrintlnAdv("2. Giải phương trình bậc 2");
        PrintAdv("Chọn 1 trong các phương án trên: ");
        out.print(RESET);
        // output
        switch (NumLimit(1, 2)) {
            case 1: {
                UnitA();
                break;
            }
            case 2: {
                UnitB();
                break;
            }
        }
        out.println();
        // ctrl
        CheckOut();
    }

    // Check a
    private static double CheckA() {
        var a = ScanDub();
        if (a == 0) {
            PrintAdv(RED, "Điều kiện a khác 0, xin nhập lại: ", RESET);
            a = CheckA();
        }
        return a;
    }

    // Unit 1
    private static void UnitA() {
        PrintAdv(GREEN, "a = ", RESET);
        var a = CheckA();
        PrintAdv(GREEN, "b = ", RESET);
        var b = ScanDub();
        PrintlnAdv(YELLOW, format("x = %s", WritePerfectDub(-b / a)));
    }

    // Unit 2
    private static void UnitB() {
        PrintAdv(GREEN, "a = ", RESET);
        var a = CheckA();
        PrintAdv(GREEN, "b = ", RESET);
        var b = ScanDub();
        PrintAdv(GREEN, "c = ", RESET);
        var c = ScanDub();
        var delta = pow(b, 2) - 4 * a * c;
        out.print(YELLOW);
        if (delta > 0) {
            PrintlnAdv(format("x1 = %s", WritePerfectDub((-b + sqrt(delta)) / (2 * a))));
            PrintlnAdv(format("x2 = %s", WritePerfectDub((-b - sqrt(delta)) / (2 * a))));
        } else if (delta == 0) {
            PrintlnAdv(format("x1 = x2 = %s", WritePerfectDub(-b / (2 * a))));
        } else {
            PrintlnAdv("Phương trình vô nghiệm.");
        }
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

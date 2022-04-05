package bai_tap_nop;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

import java.util.Scanner;

public class BaiTapJava2 {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(BLUE_BOLD, "Bài Tập Java 2");
        // content
        Main();
    }

    // Fields
    private static Scanner _scan = new Scanner(in);

    // Main
    private static void Main() {
        // selection
        out.println();
        PrintlnAdv(CYAN, "1. Đổi từ cơ số 10 sang nhị phân");
        PrintlnAdv("2. Đổi từ nhị phân sang cơ sô 10");
        PrintAdv("Chọn 1 trong các phương án trên: ");
        out.print(RESET);
        if (NumLimit(1, 2) == 1) {
            DecToBin();
        } else {
            BinToDec();
        }
        // ctrl
        CheckOut();
    }

    // Decimal to binary
    private static void DecToBin() {
        // input
        PrintAdv(GREEN, "Nhập vào số nguyên dương: ", RESET);
        var n = NumLimit(1, MAX_VALUE);
        // output
        PrintlnAdv(YELLOW, format("Số nhị phân được đổi là: %s\n", BinConvertor(n)));
    }

    // Binary convertor
    private static String BinConvertor(int n) {
        var s = "";
        while (n > 0) {
            s += String.valueOf(n % 2);
            n /= 2;
        }
        return new StringBuilder(s).reverse().toString();
    }

    // Binary to decimal
    private static void BinToDec() {
        // input
        PrintAdv(GREEN, "Nhập vào số nhị phân: ", RESET);
        var s = _scan.next();
        // output
        PrintlnAdv(YELLOW, format("Số nhị phân được đổi là: %s\n", DecConvertor(s)));
    }

    // Decimal convertor
    private static int DecConvertor(String s) {
        var sum = 0;
        for (var i = 0; i < s.length(); i++) {
            var n = 0;
            if (TryParse(String.valueOf(s.charAt(i)), n)) {
                PrintlnAdv(String.valueOf(n));
                sum += n * 2 ^ (s.length() - 1 - i);
            }
        }
        return sum;
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

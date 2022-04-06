package bai_tap_nop;

import java.util.Scanner;

import static java.lang.Integer.*;
import static java.lang.Math.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

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
        PrintlnAdv(CYAN, "1. Đổi từ cơ số 10 sang nhị phân ");
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

    // Scan binary
    private static String ScanBin() {
        var s = _scan.nextLine();
        for (var i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (c != '1' && c != '0') {
                PrintAdv(RED, "Dữ liệu nhập vào không phải số nhị phân, xin nhập lại: ", RESET);
                s = ScanBin();
                break;
            }
        }
        return s;
    }

    // Decimal to binary
    private static void DecToBin() {
        // input
        PrintAdv(GREEN, "Nhập vào số nguyên dương: ", RESET);
        // output
        PrintlnAdv(YELLOW, format("Số nhị phân được đổi là: %s\n", BinConvertor(NumLimit(1, MAX_VALUE))));
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
        // output
        PrintlnAdv(YELLOW, format("Số nhị phân được đổi là: %s\n", DecConvertor(ScanBin())));
    }

    // Decimal convertor
    private static int DecConvertor(String s) {
        var sum = 0;
        for (var i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (TryParseInt(c)) {
                sum += ParseIntAdv(c) * pow(2, (s.length() - 1 - i));
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

package bai_tap_nop;

import java.util.*;

import static java.lang.Integer.*;
import static java.lang.Math.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava2 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 2");
        // content
        run();
    }

    // Fields
    private static final Scanner mScan = new Scanner(in);

    // Main
    private static void run() {
        // selection
        out.println(CYAN);
        printlnAdv("1. Đổi từ cơ số 10 sang nhị phân ");
        printlnAdv("2. Đổi từ nhị phân sang cơ sô 10");
        printAdv("Chọn 1 trong các phương án trên: ");
        out.print(RESET);
        if (numLimit(1, 2) == 1) {
            decToBin();
        } else {
            binToDec();
        }
        out.println();
        // ctrl
        checkOut();
    }

    // Scan binary
    private static String scanBin() {
        var s = mScan.nextLine();
        for (var i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (c != '1' && c != '0') {
                printAdv(RED, "Dữ liệu nhập vào không phải số nhị phân, xin nhập lại: ", RESET);
                s = scanBin();
                break;
            }
        }
        return s;
    }

    // Decimal to binary
    private static void decToBin() {
        // input
        printAdv(GREEN, "Nhập vào số nguyên dương: ", RESET);
        // output
        printlnAdv(YELLOW, format("Số nhị phân được đổi là: %s", binConvertor(numLimit(1, MAX_VALUE))));
    }

    // Binary convertor
    private static String binConvertor(int n) {
        var s = "";
        while (n > 0) {
            s += String.valueOf(n % 2);
            n /= 2;
        }
        return new StringBuilder(s).reverse().toString();
    }

    // Binary to decimal
    private static void binToDec() {
        // input
        printAdv(GREEN, "Nhập vào số nhị phân: ", RESET);
        // output
        printlnAdv(YELLOW, format("Số nhị phân được đổi là: %s", decConvertor(scanBin())));
    }

    // Decimal convertor
    private static int decConvertor(String s) {
        var sum = 0;
        for (var i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (tryParseInt(c)) {
                sum += parseIntAdv(c) * pow(2, (s.length() - 1 - i));
            }
        }
        return sum;
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

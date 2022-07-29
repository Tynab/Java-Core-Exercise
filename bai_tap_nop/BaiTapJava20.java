package bai_tap_nop;

import java.util.*;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava20 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 20");
        // content
        run();
    }

    // Main
    private static void run() {
        // input
        out.println();
        printAdv(GREEN, "Nhập vào số phần tử của mảng số tự nhiên: ", RESET);
        var n = numLimit(1, MAX_VALUE); // pin out loop
        var list = new ArrayList<Integer>();
        for (var i = 0; i < n; i++) {
            printAdv(GREEN, format("Nhập phần tử thứ %d: ", i + 1), RESET);
            list.add(numLimit(0, MAX_VALUE));
        }
        // output
        out.print(YELLOW);
        splitEO(list);
        out.println();
        // ctrl
        checkOut();
    }

    // Split even-odd
    private static void splitEO(List<Integer> list) {
        // split
        var sEven = "";
        var sOdd = "";
        for (var item : list) {
            if (item % 2 == 0) {
                sEven += format(", %d", item);
            } else {
                sOdd += format(", %d", item);
            }
        }
        // even
        if (sEven.length() > 2) {
            printlnAdv(format("Mảng chẵn là: %s", sEven.substring(2)));
        } else {
            printlnAdv("Mảng không có phần tử chẵn.");
        }
        // odd
        if (sOdd.length() > 2) {
            printlnAdv(format("Mảng lẻ là: %s", sOdd.substring(2)));
        } else {
            printlnAdv("Mảng không có phần tử lẻ.");
        }
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

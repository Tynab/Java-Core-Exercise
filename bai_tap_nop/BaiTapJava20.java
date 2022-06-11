package bai_tap_nop;

import java.util.*;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;

import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava20 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        PrintlnAdv("Bài Tập Java 20");
        // content
        Main();
    }

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(GREEN, "Nhập vào số phần tử của mảng số tự nhiên: ", RESET);
        var n = NumLimit(1, MAX_VALUE); // pin out loop
        List<Integer> list = new ArrayList<>();
        for (var i = 0; i < n; i++) {
            PrintAdv(GREEN, format("Nhập phần tử thứ %d: ", i + 1), RESET);
            list.add(NumLimit(0, MAX_VALUE));
        }
        // output
        out.print(YELLOW);
        SplitEO(list);
        out.println();
        // ctrl
        CheckOut();
    }

    // Split even-odd
    private static void SplitEO(List<Integer> list) {
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
            PrintlnAdv(format("Mảng chẵn là: %s", sEven.substring(2)));
        } else {
            PrintlnAdv("Mảng không có phần tử chẵn.");
        }
        // odd
        if (sOdd.length() > 2) {
            PrintlnAdv(format("Mảng lẻ là: %s", sOdd.substring(2)));
        } else {
            PrintlnAdv("Mảng không có phần tử lẻ.");
        }
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

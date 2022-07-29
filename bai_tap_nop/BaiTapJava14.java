package bai_tap_nop;

import java.util.*;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava14 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 14");
        // content
        run();
    }

    // Main
    private static void run() {
        // input
        out.println();
        printAdv(GREEN, "Nhập vào số phần tử mảng: ", RESET);
        var n = numLimit(1, MAX_VALUE); // pin out loop
        var list = new ArrayList<Integer>();
        var s = "";
        for (var i = 0; i < n; i++) {
            printAdv(GREEN, format("Nhập phần tử thứ %d: ", i + 1), RESET);
            var x = scanInt();
            if (!list.contains(x)) {
                list.add(x);
                s += format(", %d", x);
            }
        }
        // output
        printlnAdv(YELLOW, format("Mảng kết quả là: %s", s.substring(2)));
        out.println();
        // ctrl
        checkOut();
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

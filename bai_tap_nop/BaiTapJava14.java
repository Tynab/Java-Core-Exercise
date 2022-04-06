package bai_tap_nop;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava14 {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(BLUE_BOLD, "Bài Tập Java 14");
        // content
        Main();
    }

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(GREEN, "Nhập vào số phần tử mảng: ", RESET);
        var n = NumLimit(1, MAX_VALUE);
        List<Integer> list = new ArrayList<>();
        for (var i = 0; i < n; i++) {
            PrintAdv(GREEN, format("Nhập phần tử thứ %d: ", i + 1), RESET);
            var x = ScanInt();
            if (!list.contains(x)) {
                list.add(x);
            }
        }
        // output
        var s = String.valueOf(list.get(0));
        for (var i = 1; i < list.size(); i++) {
            s += format(", %d", list.get(i));
        }
        PrintlnAdv(YELLOW, format("Mảng kết quả là: %s\n", s));
        // ctrl
        CheckOut();
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

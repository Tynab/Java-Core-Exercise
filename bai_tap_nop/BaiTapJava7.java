package bai_tap_nop;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava7 {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(BLUE_BOLD, "Bài Tập Java 7");
        // content
        Main();
    }

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(GREEN, "Nhập vào số tự nhiên: ", RESET);
        var n = NumLimit(0, MAX_VALUE);
        // process
        var list = DivisorList(n);
        var s = format("Các ước số của %d là: %d", n, list.get(0));
        for (var i = 1; i < list.size(); i++) {
            s += format(", %d", list.get(i));
        }
        // output
        PrintlnAdv(YELLOW, format("%s\n", s));
        // ctrl
        CheckOut();
    }

    // Divisor
    private static List<Integer> DivisorList(int n) {
        List<Integer> list = new ArrayList<>();
        for (var i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        return list;
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

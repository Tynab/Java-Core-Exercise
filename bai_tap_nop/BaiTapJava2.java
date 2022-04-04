package bai_tap_nop;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static java.util.Collections.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava2 {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(CYAN_BOLD, "Bài Tập Java 2");
        // content
        Main();
    }

    // Main
    private static void Main() {
        // selection
        out.println();
        PrintlnAdv(BLUE, "1. Đổi từ cơ số 10 sang nhị phân");
        PrintlnAdv("2. Đổi từ nhị phân sang cơ sô 10");
        PrintAdv("Chọn 1 trong các phương án trên: ");
        out.print(RESET);
        if (NumLimit(1, 2) == 1) {
            DecToBin();
        } else {

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
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 2);
            n /= 2;
        }
        reverse(list);
        var s = "";
        for (var item : list) {
            s += valueOf(item);
        }
        return s;
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

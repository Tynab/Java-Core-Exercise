package bai_tap_nop;

import java.util.*;

import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava17 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        PrintlnAdv("Bài Tập Java 17");
        // content
        Main();
    }

    // Fields
    private static final int _limit = 1000;
    private static int _counter;

    // Main
    private static void Main() {
        // cap
        out.println();
        PrintAdv(GREEN, "Nhập vào số dự đoán từ 1 đến 1000: ", RESET);
        // process
        _counter = 0;
        GuessX(new Random().nextInt(_limit - 1) + 1);
        out.println();
        // ctrl
        CheckOut();
    }

    // Guess x
    private static void GuessX(int x) {
        _counter++;
        var n = NumLimit(1, _limit);
        if (n < x) {
            PrintAdv(RED, "Nhỏ hơn số cần tìm, mời đoán lại: ", RESET);
            GuessX(x);
        } else if (n > x) {
            PrintAdv(RED, "Lớn hơn số cần tìm, mời đoán lại: ", RESET);
            GuessX(x);
        } else {
            PrintlnAdv(YELLOW, format("CHÍNH XÁC! Đoán sai %d lần.", _counter));
        }
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

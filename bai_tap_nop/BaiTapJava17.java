package bai_tap_nop;

import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

import java.util.Random;

public class BaiTapJava17 {
    public static void main(String[] args) {
        out.println();
        PrintlnAdv(BLUE_BOLD, "Bài Tập Java 17");
        // content
        Main();
    }

    // Fields
    private static final int _limit = 1000;
    private static int _counter;

    // Main
    private static void Main() {
        // set
        _counter = 0;
        Random random = new Random();
        var x = random.nextInt(_limit - 1) + 1;
        // cap
        out.println();
        PrintAdv(GREEN, "Nhập vào số dự đoán từ 1 đến 1000: ", RESET);
        // output
        GuessX(x);
        // ctrl
        CheckOut();
    }

    // Guess x
    private static void GuessX(int x) {
        _counter++;
        var n = NumLimit(1, _limit);
        if (n < x) {
            PrintAdv("Nhỏ hơn số cần tìm, mời đoán lại: ");
            GuessX(x);
        } else if (n > x) {
            PrintAdv("Lớn hơn số cần tìm, mời đoán lại: ");
            GuessX(x);
        } else {
            PrintlnAdv(YELLOW, format("CHÍNH XÁC! Đoán sai %d lần.\n", _counter));
        }
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

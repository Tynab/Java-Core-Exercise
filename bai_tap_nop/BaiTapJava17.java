package bai_tap_nop;

import java.util.*;

import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava17 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 17");
        // content
        run();
    }

    // Fields
    private static final int LIMIT = 1000;
    private static int mCounter;

    // Main
    private static void run() {
        // cap
        out.println();
        printAdv(GREEN, "Nhập vào số dự đoán từ 1 đến 1000: ", RESET);
        // process
        mCounter = 0;
        guessX(new Random().nextInt(LIMIT - 1) + 1);
        out.println();
        // ctrl
        checkOut();
    }

    // Guess x
    private static void guessX(int x) {
        mCounter++;
        var n = numLimit(1, LIMIT);
        if (n < x) {
            printAdv(RED, "Nhỏ hơn số cần tìm, mời đoán lại: ", RESET);
            guessX(x);
        } else if (n > x) {
            printAdv(RED, "Lớn hơn số cần tìm, mời đoán lại: ", RESET);
            guessX(x);
        } else {
            printlnAdv(YELLOW, format("CHÍNH XÁC! Đoán sai %d lần.", mCounter));
        }
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

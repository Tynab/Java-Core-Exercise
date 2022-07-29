package bai_tap_nop;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava16 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 16");
        // content
        run();
    }

    // Fields
    private static final int YEAR_START = 1900;

    // Main
    private static void run() {
        // input
        out.println();
        printAdv(GREEN, "Nhập vào năm cần kiểm tra: ", RESET);
        var year = yearLimit(MAX_VALUE);
        // output
        out.print(YELLOW);
        if (year == YEAR_START || year % 4 != 0) {
            printlnAdv(format("Năm %d là năm không nhuận.", year));
        } else {
            printlnAdv(format("Năm %d là năm nhuận.", year));
        }
        out.println();
        // ctrl
        checkOut();
    }

    // Year limit
    private static int yearLimit(int max) {
        var n = scanInt();
        if (n < YEAR_START) {
            printAdv(RED, format("Không xác định được lịch trước năm %d, xin nhập lại: ", YEAR_START), RESET);
            n = yearLimit(max);
        } else if (n > max) {
            printAdv(RED, "Không xác định, xin nhập lại: ", RESET);
            n = yearLimit(max);
        }
        return n;
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

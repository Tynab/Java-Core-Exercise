package bai_tap_nop;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava16 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        PrintlnAdv("Bài Tập Java 16");
        // content
        Main();
    }

    // Fields
    private static final int _latter_year_start = 1900;

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(GREEN, "Nhập vào năm cần kiểm tra: ", RESET);
        var year = YearLimit(MAX_VALUE);
        // output
        out.print(YELLOW);
        if (year == _latter_year_start || year % 4 != 0) {
            PrintlnAdv(format("Năm %d là năm không nhuận.", year));
        } else {
            PrintlnAdv(format("Năm %d là năm nhuận.", year));
        }
        out.println();
        // ctrl
        CheckOut();
    }

    // Year limit
    private static int YearLimit(int max) {
        var n = ScanInt();
        if (n < _latter_year_start) {
            PrintAdv(RED, format("Không xác định được lịch trước năm %d, xin nhập lại: ", _latter_year_start), RESET);
            n = YearLimit(max);
        } else if (n > max) {
            PrintAdv(RED, "Không xác định, xin nhập lại: ", RESET);
            n = YearLimit(max);
        }
        return n;
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

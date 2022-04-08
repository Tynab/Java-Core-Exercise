package bai_tap_nop;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava18 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        PrintlnAdv("Bài Tập Java 18");
        // content
        Main();
    }

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(GREEN, "Nhập vào số tiền hiện có: ", RESET);
        var money = NumLimit(1, MAX_VALUE);
        PrintAdv(GREEN, "Nhập vào lãi suất (%): ", RESET);
        var rate = RateLimit(0, 100);
        PrintAdv(GREEN, "Số tiền muốn tích lũy là: ", RESET);
        var sum = SumLimit(money, MAX_VALUE);
        // output
        PrintlnAdv(YELLOW, format("Sau %s sẽ đạt được số tiền mong muốn.", Handle(money, sum, rate)));
        out.println();
        // ctrl
        CheckOut();
    }

    // Rate limit
    public static double RateLimit(double min, double max) {
        var n = ScanDub();
        if (n <= min || n > max) {
            PrintAdv(RED, "Lãi suất từ 0% đến 100%, xin nhập lại: ", RESET);
            n = RateLimit(min, max);
        }
        return n;
    }

    // Sum limit
    private static int SumLimit(int min, int max) {
        var n = ScanInt();
        if (n < min) {
            PrintAdv(RED, "Số tiền mong muốn phải lớn hơn số tiền hiện có, xin nhập lại: ", RESET);
            n = SumLimit(min, max);
        } else if (n > max) {
            PrintAdv(RED, "Không xác định, xin nhập lại: ", RESET);
            n = SumLimit(min, max);
        }
        return n;
    }

    // Handle
    private static String Handle(int money, int sum, double rate) {
        var month = 0;
        var incre = (double) money;
        while (incre < sum) {
            month++;
            incre += incre * rate / 100;
        }
        return month >= 12
                ? month % 12 == 0 ? format("%d năm", month / 12) : format("%d năm %d tháng", month / 12, month % 12)
                : format("%d tháng", month % 12);
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

package bai_tap_nop;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava18 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 18");
        // content
        run();
    }

    // Main
    private static void run() {
        // input
        out.println();
        printAdv(GREEN, "Nhập vào số tiền hiện có: ", RESET);
        var money = numLimit(1, MAX_VALUE);
        printAdv(GREEN, "Nhập vào lãi suất (%): ", RESET);
        var rate = rateLimit(0, 100);
        printAdv(GREEN, "Số tiền muốn tích lũy là: ", RESET);
        var sum = sumLimit(money, MAX_VALUE);
        // output
        printlnAdv(YELLOW, format("Sau %s sẽ đạt được số tiền mong muốn.", handle(money, sum, rate)));
        out.println();
        // ctrl
        checkOut();
    }

    // Rate limit
    public static double rateLimit(double min, double max) {
        var n = scanDub();
        if (n <= min || n > max) {
            printAdv(RED, "Lãi suất từ 0% đến 100%, xin nhập lại: ", RESET);
            n = rateLimit(min, max);
        }
        return n;
    }

    // Sum limit
    private static int sumLimit(int min, int max) {
        var n = scanInt();
        if (n < min) {
            printAdv(RED, "Số tiền mong muốn phải lớn hơn số tiền hiện có, xin nhập lại: ", RESET);
            n = sumLimit(min, max);
        } else if (n > max) {
            printAdv(RED, "Không xác định, xin nhập lại: ", RESET);
            n = sumLimit(min, max);
        }
        return n;
    }

    // Handle
    private static String handle(int money, int sum, double rate) {
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
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

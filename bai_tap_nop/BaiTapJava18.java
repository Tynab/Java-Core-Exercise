package bai_tap_nop;

import static java.lang.Float.*;
import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava18 {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(BLUE_BOLD, "Bài Tập Java 18");
        // content
        Main();
    }

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(GREEN, "Nhập vào số tiền hiện có: ", RESET);
        var money = NumLimit(1, Integer.MAX_VALUE);
        PrintAdv(GREEN, "Nhập vào lãi suất (%): ", RESET);
        var rate = NumLimit(0, Float.MAX_VALUE);
        PrintAdv(GREEN, "Số tiền muốn tích lũy là: ", RESET);
        var sum = NumLimit(money, Integer.MAX_VALUE);
        // output
        //PrintlnAdv(YELLOW, format("Tổng các chữ số của %d là: %d\n", n, SumMe(n)));
        // ctrl
        CheckOut();
    }

    // Number limit float
    public static float RateLimit(float min, float max) {
        var n = ScanFloat();
        if (n <= min || n >= max) {
            PrintAdv(RED, "Không xác định, xin nhập lại: ", RESET);
            n = NumLimit(min, max);
        }
        return n;
    }

    // Number limit float
    private static float OutLimit(float min, float max) {
        var n = ScanFloat();
        if (n < min) {
            PrintAdv(RED, "Thời gian ra về không thể trước thời gian vào, xin nhập lại: ", RESET);
            n = OutLimit(min, max);
        } else if (n > max) {
            PrintAdv(RED, "Thời gian mở cửa từ 9h đến 24h, xin nhập lại: ", RESET);
            n = OutLimit(min, max);
        }
        return n;
    }

    // Sum me
    private static int SumMe(int n) {
        var sum = 0;
        var num = String.valueOf(n);
        for (var i = 0; i < num.length(); i++) {
            sum += ParseIntAdv(num.charAt(i));
        }
        return sum;
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

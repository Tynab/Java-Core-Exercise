package bai_tap_nop;

import java.util.*;

import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava22 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 22");
        // content
        run();
    }

    // Fields
    private static final Scanner mScan = new Scanner(in);

    // Main
    private static void run() {
        // input
        out.println();
        printAdv(GREEN, "Nhập vào chuỗi: ", RESET);
        var str = mScan.nextLine();
        // output
        var res = handle(str);
        var sOut = res.length() > 0 ? format("Chuỗi palindromic là: %s", res) : "Không tìm thấy chuỗi palindromic.";
        printlnAdv(YELLOW, sOut);
        out.println();
        // ctrl
        checkOut();
    }

    // Handle
    private static String handle(String str) {
        var s = "";
        var strReverse = new StringBuilder(str).reverse().toString();
        for (var i = 0; i < str.length() / 2; i++) {
            var item = strReverse.charAt(i);
            if (str.charAt(i) == item) {
                s += item;
            } else {
                break;
            }
        }
        return new StringBuilder(s).reverse().toString();
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

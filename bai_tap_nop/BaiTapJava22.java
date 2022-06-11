package bai_tap_nop;

import java.util.*;

import static java.lang.String.*;
import static java.lang.System.*;

import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava22 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        PrintlnAdv("Bài Tập Java 22");
        // content
        Main();
    }

    // Fields
    private static final Scanner _scan = new Scanner(in);

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(GREEN, "Nhập vào chuỗi: ", RESET);
        var str = _scan.nextLine();
        // output
        var res = Handle(str);
        var sOut = res.length() > 0 ? format("Chuỗi palindromic là: %s", res) : "Không tìm thấy chuỗi palindromic.";
        PrintlnAdv(YELLOW, sOut);
        out.println();
        // ctrl
        CheckOut();
    }

    // Handle
    private static String Handle(String str) {
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
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

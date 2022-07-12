package bai_tap_nop;

import java.util.*;

import static java.lang.String.*;
import static java.lang.System.*;

import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava6 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        PrintlnAdv("Bài Tập Java 6");
        // content
        Main();
    }

    // Fields
    private static final Scanner _scan = new Scanner(in);

    // Main
    private static void Main() {
        // cap
        out.println();
        PrintAdv(GREEN, "Nhập vào chuỗi: ", RESET);
        // output
        PrintlnAdv(YELLOW, format("Chuỗi đảo ngược là: %s", new StringBuilder(_scan.nextLine()).reverse().toString()));
        out.println();
        // ctrl
        CheckOut();
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

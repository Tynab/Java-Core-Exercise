package bai_tap_nop;

import java.util.*;

import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava6 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 6");
        // content
        run();
    }

    // Fields
    private static final Scanner mScan = new Scanner(in);

    // Main
    private static void run() {
        // cap
        out.println();
        printAdv(GREEN, "Nhập vào chuỗi: ", RESET);
        // output
        printlnAdv(YELLOW, format("Chuỗi đảo ngược là: %s", new StringBuilder(mScan.nextLine()).reverse().toString()));
        out.println();
        // ctrl
        checkOut();
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

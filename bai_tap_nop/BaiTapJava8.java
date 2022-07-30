package bai_tap_nop;

import java.util.*;

import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava8 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 8");
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
        printlnAdv(YELLOW, format("Chuỗi in hoa mỗi ký tự đầu là: %s", toTitleCaseAdv(mScan.nextLine())));
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

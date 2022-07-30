package bai_tap_nop;

import java.util.*;

import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava15 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 15");
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
        var s = mScan.nextLine();
        // cap
        out.print(CYAN);
        printlnAdv("1. In ra độ dài chuỗi                  ");
        printlnAdv("2. In ra ký tự tại một vị trí nhất định");
        printlnAdv("3. Kiểm tra chuỗi phụ trong chuỗi      ");
        printAdv("Chọn 1 trong các phương án trên: ");
        out.print(RESET);
        // output
        switch (numLimit(1, 3)) {
            case 1: {
                unitA(s);
                break;
            }
            case 2: {
                unitB(s);
                break;
            }
            case 3: {
                unitC(s);
                break;
            }
        }
        out.println();
        // ctrl
        checkOut();
    }

    // Get all index of
    private static void getAllIndexOf(List<Integer> list, String s, String str, int padding) {
        if (s.contains(str)) {
            var index = s.indexOf(str);
            list.add(index + padding);
            var startPath = index + 1;
            padding += startPath;
            getAllIndexOf(list, s.substring(startPath), str, padding);
        }
    }

    // Unit 1
    private static void unitA(String s) {
        printlnAdv(YELLOW, format("Độ dài chuỗi là: %d", s.length()));
    }

    // Unit 2
    private static void unitB(String s) {
        // input
        printAdv(GREEN, "Nhập vị trí ký tự cần tìm trong chuỗi: ", RESET);
        var path = numLimit(1, s.length());
        // out put
        printlnAdv(YELLOW, format("Ký tự ở vị trí thứ %d trong chuỗi là: %c", path, s.charAt(path - 1)));
    }

    // Unit 3
    private static void unitC(String s) {
        // input
        printAdv(GREEN, "Nhập chuỗi cần tìm: ", RESET);
        // process
        var list = new ArrayList<Integer>();
        getAllIndexOf(list, s, mScan.nextLine(), 0);
        // out put
        out.print(YELLOW);
        var max = list.size();
        if (max > 0) {
            var sOut = String.valueOf(list.get(0) + 1);
            for (var i = 1; i < max; i++) {
                sOut += format(", %d", list.get(i) + 1);
            }
            printlnAdv(format("Chuỗi cần tìm ở vị trí thứ %s.", sOut));
        } else {
            printlnAdv("Không tìm thấy chuỗi cần tìm.");
        }
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

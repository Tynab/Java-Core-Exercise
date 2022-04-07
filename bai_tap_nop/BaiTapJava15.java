package bai_tap_nop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava15 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        PrintlnAdv("Bài Tập Java 15");
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
        var s = _scan.nextLine();
        // cap
        out.print(CYAN);
        PrintlnAdv("1. In ra độ dài chuỗi                  ");
        PrintlnAdv("2. In ra ký tự tại một vị trí nhất định");
        PrintlnAdv("3. Kiểm tra chuỗi phụ trong chuỗi      ");
        PrintAdv("Chọn 1 trong các phương án trên: ");
        out.print(RESET);
        // output
        switch (NumLimit(1, 3)) {
            case 1: {
                UnitA(s);
                break;
            }
            case 2: {
                UnitB(s);
                break;
            }
            case 3: {
                UnitC(s);
                break;
            }
        }
        out.println();
        // ctrl
        CheckOut();
    }

    // Get all index of
    private static void GetAllIndexOf(List<Integer> list, String s, String str, int padding) {
        if (s.contains(str)) {
            var index = s.indexOf(str);
            list.add(index + padding);
            var startPath = index + 1;
            padding += startPath;
            GetAllIndexOf(list, s.substring(startPath), str, padding);
        }
    }

    // Unit 1
    private static void UnitA(String s) {
        PrintlnAdv(YELLOW, format("Độ dài chuỗi là: %d", s.length()));
    }

    // Unit 2
    private static void UnitB(String s) {
        // input
        PrintAdv(GREEN, "Nhập vị trí ký tự cần tìm trong chuỗi: ", RESET);
        var path = NumLimit(1, s.length());
        // out put
        PrintlnAdv(YELLOW, format("Ký tự ở vị trí thứ %d trong chuỗi là: %c", path, s.charAt(path - 1)));
    }

    // Unit 3
    private static void UnitC(String s) {
        // input
        PrintAdv(GREEN, "Nhập chuỗi cần tìm: ", RESET);
        // process
        List<Integer> list = new ArrayList<>();
        GetAllIndexOf(list, s, _scan.nextLine(), 0);
        // out put
        out.print(YELLOW);
        var max = list.size();
        if (max > 0) {
            var txt = String.valueOf(list.get(0) + 1);
            for (var i = 1; i < max; i++) {
                txt += format(", %d", list.get(i) + 1);
            }
            PrintlnAdv(format("Chuỗi cần tìm ở vị trí thứ %s.", txt));
        } else {
            PrintlnAdv("Không tìm thấy chuỗi cần tìm.");
        }
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

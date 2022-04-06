package bai_tap_nop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static java.util.Collections.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava13 {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(BLUE_BOLD, "Bài Tập Java 13");
        // content
        Main();
    }

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(GREEN, "Nhập vào số phần tử mảng: ", RESET);
        var n = NumLimit(1, MAX_VALUE);
        List<Integer> list = new ArrayList<>();
        for (var i = 0; i < n; i++) {
            PrintAdv(GREEN, format("Nhập phần tử thứ %d: ", i + 1), RESET);
            list.add(NumLimit(MIN_VALUE, MAX_VALUE));
        }
        // cap
        PrintlnAdv(CYAN, "1. Tính giá trị trung bình             ");
        PrintlnAdv("2. Tìm phần tử lớn nhất, nhỏ nhất      ");
        PrintlnAdv("3. Tìm phần tử âm lớn nhất, nhỏ nhất   ");
        PrintlnAdv("4. Tìm phần tử dương lớn nhất, nhỏ nhất");
        PrintlnAdv("5. In ra các phần tử chẵn, lẻ          ");
        PrintlnAdv("6. Thêm một phần tử theo index         ");
        PrintlnAdv("7. Xóa một phần tử theo index          ");
        PrintAdv("Chọn 1 trong các phương án trên: ");
        out.print(RESET);
        // output
        switch (NumLimit(1, 9)) {
            case 1: {
                UnitA(list);
                break;
            }
            case 2: {
                UnitB(list);
                break;
            }
            case 3: {
                UnitC(list);
                break;
            }
        }
        // ctrl
        CheckOut();
    }

    // Unit 1
    private static void UnitA(List<Integer> list) {
        var sum = 0;
        for (var item : list) {
            sum += item;
        }
        var av = (float) sum / list.size();
        if (av == (int) av) {
            PrintlnAdv(YELLOW, format("Giá trị trung bình của mảng là: %d\n", (int) av));
        } else {
            PrintlnAdv(YELLOW, format("Giá trị trung bình của mảng là: %s\n", av));
        }
    }

    // Unit 2
    private static void UnitB(List<Integer> list) {
        PrintlnAdv(YELLOW, format("Phần tử lớn nhất là: %d", max(list)));
        PrintlnAdv(format("Phần tử nhỏ nhất là: %d\n", min(list)));
    }

    // Unit 3
    private static void UnitC(List<Integer> list) {
        var is_max_has = false;
        var is_min_has = false;
        var max = MIN_VALUE;
        var min = MAX_VALUE;
        for (var item : list) {
            if (item < 0) {
                if (item > max) {
                    is_max_has = true;
                    max = item;
                }
                if (item < min) {
                    is_min_has = true;
                    min = item;
                }
            }
        }
        if (is_max_has || is_min_has) {
            PrintlnAdv(YELLOW, format("Phần tử âm lớn nhất là: %d", max));
            PrintlnAdv(format("Phần tử âm nhỏ nhất là: %d\n", min));
        } else {
            PrintlnAdv(YELLOW, "Mảng không có phần tử âm.\n");
        }
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

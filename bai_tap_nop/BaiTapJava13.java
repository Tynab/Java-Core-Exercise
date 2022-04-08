package bai_tap_nop;

import java.util.ArrayList;
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
        out.println(BLUE_BOLD);
        PrintlnAdv("Bài Tập Java 13");
        // content
        Main();
    }

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(GREEN, "Nhập vào số phần tử mảng: ", RESET);
        var n = NumLimit(1, MAX_VALUE); // pin out loop
        List<Integer> list = new ArrayList<>();
        for (var i = 0; i < n; i++) {
            PrintAdv(GREEN, format("Nhập phần tử thứ %d: ", i + 1), RESET);
            list.add(ScanInt());
        }
        // cap
        out.print(CYAN);
        PrintlnAdv("1. Tính giá trị trung bình             ");
        PrintlnAdv("2. Tìm phần tử lớn nhất, nhỏ nhất      ");
        PrintlnAdv("3. Tìm phần tử âm lớn nhất, nhỏ nhất   ");
        PrintlnAdv("4. Tìm phần tử dương lớn nhất, nhỏ nhất");
        PrintlnAdv("5. In ra các phần tử chẵn, lẻ          ");
        PrintlnAdv("6. Thêm một phần tử theo vị trí        ");
        PrintlnAdv("7. Xóa một phần tử theo vị trí         ");
        PrintAdv("Chọn 1 trong các phương án trên: ");
        out.print(RESET);
        // output
        switch (NumLimit(1, 7)) {
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
            case 4: {
                UnitD(list);
                break;
            }
            case 5: {
                UnitE(list);
                break;
            }
            case 6: {
                UnitF(list);
                break;
            }
            case 7: {
                UnitG(list);
                break;
            }
        }
        out.println();
        // ctrl
        CheckOut();
    }

    // Unit 1
    private static void UnitA(List<Integer> list) {
        // sum
        var sum = 0;
        for (var item : list) {
            sum += item;
        }
        // average
        PrintlnAdv(YELLOW, format("Giá trị trung bình của mảng là: %s", WritePerfectDub((double) sum / list.size())));
    }

    // Unit 2
    private static void UnitB(List<Integer> list) {
        out.print(YELLOW);
        PrintlnAdv(format("Phần tử lớn nhất trong mảng là: %d", max(list)));
        PrintlnAdv(format("Phần tử nhỏ nhất trong mảng là: %d", min(list)));
    }

    // Unit 3
    private static void UnitC(List<Integer> list) {
        // scan
        List<Integer> resList = new ArrayList<>();
        for (var item : list) {
            if (item < 0) {
                resList.add(item);
            }
        }
        // check back
        out.print(YELLOW);
        if (resList.size() > 0) {
            PrintlnAdv(format("Phần tử âm lớn nhất trong mảng là: %d", max(resList)));
            PrintlnAdv(format("Phần tử âm nhỏ nhất trong mảng là: %d", min(resList)));
        } else {
            PrintlnAdv("Mảng không có phần tử âm.");
        }
    }

    // Unit 4
    private static void UnitD(List<Integer> list) {
        // scan
        List<Integer> resList = new ArrayList<>();
        for (var item : list) {
            if (item > 0) {
                resList.add(item);
            }
        }
        // check back
        out.print(YELLOW);
        if (resList.size() > 0) {
            PrintlnAdv(format("Phần tử dương lớn nhất trong mảng là: %d", max(resList)));
            PrintlnAdv(format("Phần tử dương nhỏ nhất trong mảng là: %d", min(resList)));
        } else {
            PrintlnAdv("Mảng không có phần tử dương.");
        }
    }

    // Unit 5
    private static void UnitE(List<Integer> list) {
        // transfer
        List<Integer> shortList = new ArrayList<>();
        for (var item : list) {
            if (!shortList.contains(item)) {
                shortList.add(item);
            }
        }
        // split
        var sEven = "";
        var sOdd = "";
        for (var item : shortList) {
            if (item % 2 == 0) {
                sEven += format(", %d", item);
            } else {
                sOdd += format(", %d", item);
            }
        }
        out.print(YELLOW);
        // even
        if (sEven.length() > 2) {
            PrintlnAdv(format("Các phần tử chẵn trong mảng là: %s", sEven.substring(2)));
        } else {
            PrintlnAdv("Mảng không có phần tử chẵn.");
        }
        // odd
        if (sOdd.length() > 2) {
            PrintlnAdv(format("Các phần tử lẻ trong mảng là: %s", sOdd.substring(2)));
        } else {
            PrintlnAdv("Mảng không có phần tử lẻ.");
        }
    }

    // Unit 6
    private static void UnitF(List<Integer> list) {
        // input
        PrintAdv(GREEN, "Nhập số muốn thêm vào mảng: ", RESET);
        var x = ScanInt();
        PrintAdv(GREEN, "Nhập vị trí phần tử mới cần chèn trong mảng: ", RESET);
        var max = list.size();
        // process
        list.add(NumLimit(1, max + 1) - 1, x);
        // output
        var s = String.valueOf(list.get(0));
        for (var i = 1; i <= max; i++) {
            s += format(", %d", list.get(i));
        }
        PrintlnAdv(YELLOW, format("Mảng mới là: %s", s));
    }

    // Unit 7
    private static void UnitG(List<Integer> list) {
        // input
        PrintAdv(GREEN, "Nhập vị trí phần tử cần xóa trong mảng: ", RESET);
        var max = list.size();
        // add
        list.remove(NumLimit(1, max) - 1);
        // output
        var s = String.valueOf(list.get(0));
        for (var i = 1; i < max - 1; i++) {
            s += format(", %d", list.get(i));
        }
        PrintlnAdv(YELLOW, format("Mảng mới là: %s", s));
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

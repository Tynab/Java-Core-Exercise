package bai_tap_nop;

import java.util.*;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static java.util.Collections.max;
import static java.util.Collections.min;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava13 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 13");
        // content
        run();
    }

    // Main
    private static void run() {
        // input
        out.println();
        printAdv(GREEN, "Nhập vào số phần tử mảng: ", RESET);
        var n = numLimit(1, MAX_VALUE); // pin out loop
        var list = new ArrayList<Integer>();
        for (var i = 0; i < n; i++) {
            printAdv(GREEN, format("Nhập phần tử thứ %d: ", i + 1), RESET);
            list.add(scanInt());
        }
        // cap
        out.print(CYAN);
        printlnAdv("1. Tính giá trị trung bình             ");
        printlnAdv("2. Tìm phần tử lớn nhất, nhỏ nhất      ");
        printlnAdv("3. Tìm phần tử âm lớn nhất, nhỏ nhất   ");
        printlnAdv("4. Tìm phần tử dương lớn nhất, nhỏ nhất");
        printlnAdv("5. In ra các phần tử chẵn, lẻ          ");
        printlnAdv("6. Thêm một phần tử theo vị trí        ");
        printlnAdv("7. Xóa một phần tử theo vị trí         ");
        printAdv("Chọn 1 trong các phương án trên: ");
        out.print(RESET);
        // output
        switch (numLimit(1, 7)) {
            case 1: {
                unitA(list);
                break;
            }
            case 2: {
                unitB(list);
                break;
            }
            case 3: {
                unitC(list);
                break;
            }
            case 4: {
                unitD(list);
                break;
            }
            case 5: {
                unitE(list);
                break;
            }
            case 6: {
                unitF(list);
                break;
            }
            case 7: {
                unitG(list);
                break;
            }
        }
        out.println();
        // ctrl
        checkOut();
    }

    // Unit 1
    private static void unitA(List<Integer> list) {
        // sum
        var sum = 0;
        for (var item : list) {
            sum += item;
        }
        // average
        printlnAdv(YELLOW, format("Giá trị trung bình của mảng là: %s", writePerfectDub((double) sum / list.size())));
    }

    // Unit 2
    private static void unitB(List<Integer> list) {
        out.print(YELLOW);
        printlnAdv(format("Phần tử lớn nhất trong mảng là: %d", max(list)));
        printlnAdv(format("Phần tử nhỏ nhất trong mảng là: %d", min(list)));
    }

    // Unit 3
    private static void unitC(List<Integer> list) {
        // scan
        var resList = new ArrayList<Integer>();
        for (var item : list) {
            if (item < 0) {
                resList.add(item);
            }
        }
        // check back
        out.print(YELLOW);
        if (resList.size() > 0) {
            printlnAdv(format("Phần tử âm lớn nhất trong mảng là: %d", max(resList)));
            printlnAdv(format("Phần tử âm nhỏ nhất trong mảng là: %d", min(resList)));
        } else {
            printlnAdv("Mảng không có phần tử âm.");
        }
    }

    // Unit 4
    private static void unitD(List<Integer> list) {
        // scan
        var resList = new ArrayList<Integer>();
        for (var item : list) {
            if (item > 0) {
                resList.add(item);
            }
        }
        // check back
        out.print(YELLOW);
        if (resList.size() > 0) {
            printlnAdv(format("Phần tử dương lớn nhất trong mảng là: %d", max(resList)));
            printlnAdv(format("Phần tử dương nhỏ nhất trong mảng là: %d", min(resList)));
        } else {
            printlnAdv("Mảng không có phần tử dương.");
        }
    }

    // Unit 5
    private static void unitE(List<Integer> list) {
        // transfer
        var shortList = new ArrayList<Integer>();
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
            printlnAdv(format("Các phần tử chẵn trong mảng là: %s", sEven.substring(2)));
        } else {
            printlnAdv("Mảng không có phần tử chẵn.");
        }
        // odd
        if (sOdd.length() > 2) {
            printlnAdv(format("Các phần tử lẻ trong mảng là: %s", sOdd.substring(2)));
        } else {
            printlnAdv("Mảng không có phần tử lẻ.");
        }
    }

    // Unit 6
    private static void unitF(List<Integer> list) {
        // input
        printAdv(GREEN, "Nhập số muốn thêm vào mảng: ", RESET);
        var x = scanInt();
        printAdv(GREEN, "Nhập vị trí phần tử mới cần chèn trong mảng: ", RESET);
        var max = list.size();
        // process
        list.add(numLimit(1, max + 1) - 1, x);
        // output
        var s = String.valueOf(list.get(0));
        for (var i = 1; i <= max; i++) {
            s += format(", %d", list.get(i));
        }
        printlnAdv(YELLOW, format("Mảng mới là: %s", s));
    }

    // Unit 7
    private static void unitG(List<Integer> list) {
        // input
        printAdv(GREEN, "Nhập vị trí phần tử cần xóa trong mảng: ", RESET);
        var max = list.size();
        // add
        list.remove(numLimit(1, max) - 1);
        // output
        var s = String.valueOf(list.get(0));
        for (var i = 1; i < max - 1; i++) {
            s += format(", %d", list.get(i));
        }
        printlnAdv(YELLOW, format("Mảng mới là: %s", s));
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

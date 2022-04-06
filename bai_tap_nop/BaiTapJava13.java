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
            list.add(ScanInt());
        }
        // cap
        PrintlnAdv(CYAN, "1. Tính giá trị trung bình             ");
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
        var av = (float) sum / list.size();
        if (av == (int) av) {
            PrintlnAdv(YELLOW, format("Giá trị trung bình của mảng là: %d\n", (int) av));
        } else {
            PrintlnAdv(YELLOW, format("Giá trị trung bình của mảng là: %s\n", av));
        }
    }

    // Unit 2
    private static void UnitB(List<Integer> list) {
        PrintlnAdv(YELLOW, format("Phần tử lớn nhất trong mảng là: %d", max(list)));
        PrintlnAdv(format("Phần tử nhỏ nhất trong mảng là: %d\n", min(list)));
    }

    // Unit 3
    private static void UnitC(List<Integer> list) {
        // scan
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
        // check back
        if (is_max_has || is_min_has) {
            PrintlnAdv(YELLOW, format("Phần tử âm lớn nhất trong mảng là: %d", max));
            PrintlnAdv(format("Phần tử âm nhỏ nhất trong mảng là: %d\n", min));
        } else {
            PrintlnAdv(YELLOW, "Mảng không có phần tử âm.\n");
        }
    }

    // Unit 4
    private static void UnitD(List<Integer> list) {
        // scan
        var is_max_has = false;
        var is_min_has = false;
        var max = MIN_VALUE;
        var min = MAX_VALUE;
        for (var item : list) {
            if (item > 0) {
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
        // check back
        if (is_max_has || is_min_has) {
            PrintlnAdv(YELLOW, format("Phần tử dương lớn nhất trong mảng là: %d", max));
            PrintlnAdv(format("Phần tử dương nhỏ nhất trong mảng là: %d\n", min));
        } else {
            PrintlnAdv(YELLOW, "Mảng không có phần tử dương.\n");
        }
    }

    // Unit 5
    private static void UnitE(List<Integer> list) {
        // split
        List<Integer> listE = new ArrayList<>();
        List<Integer> listO = new ArrayList<>();
        for (var item : list) {
            if (item % 2 == 0) {
                listE.add(item);
            } else {
                listO.add(item);
            }
        }
        // even
        var maxE = listE.size();
        if (maxE > 0) {
            var sE = String.valueOf(listE.get(0));
            for (var i = 1; i < maxE; i++) {
                sE += format(", %d", listE.get(i));
            }
            PrintlnAdv(YELLOW, format("Các phần tử chẵn trong mảng là: %s", sE));
        } else {
            PrintlnAdv(YELLOW, "Mảng không có phần tử chẵn.");
        }
        // odd
        var maxO = listO.size();
        if (maxO > 0) {
            var sO = String.valueOf(listO.get(0));
            for (var i = 1; i < maxO; i++) {
                sO += format(", %d", listO.get(i));
            }
            PrintlnAdv(format("Các phần tử lẻ trong mảng là: %s\n", sO));
        } else {
            PrintlnAdv("Mảng không có phần tử lẻ.\n");
        }
    }

    // Unit 6
    private static void UnitF(List<Integer> list) {
        // input
        PrintAdv(GREEN, "Nhập số muốn thêm vào mảng: ", RESET);
        var x = ScanInt();
        PrintAdv(GREEN, "Nhập vị trí phần tử mới cần chèn trong mảng: ", RESET);
        var max = list.size();
        var path = NumLimit(1, max + 1);
        // process
        list.add(path - 1, x);
        // output
        var s = String.valueOf(list.get(0));
        for (var i = 1; i <= max; i++) {
            s += format(", %d", list.get(i));
        }
        PrintlnAdv(YELLOW, format("Mảng mới là: %s\n", s));
    }

    // Unit 6
    private static void UnitG(List<Integer> list) {
        // input
        PrintAdv(GREEN, "Nhập vị trí phần tử cần xóa trong mảng: ", RESET);
        var max = list.size();
        var path = NumLimit(1, max);
        // add
        list.remove(path - 1);
        // output
        var s = String.valueOf(list.get(0));
        for (var i = 1; i < max - 1; i++) {
            s += format(", %d", list.get(i));
        }
        PrintlnAdv(YELLOW, format("Mảng mới là: %s\n", s));
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

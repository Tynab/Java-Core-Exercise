package list_exercise;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class ListExercise {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(CYAN_BOLD, "Input Exersice");
        // content
        Main();
    }

    // Fields
    private static Scanner scan = new Scanner(in);

    // Main
    private static void Main() {
        // var
        ArrayList<String> list = new ArrayList<>();
        var nMax = 2;
        // cap
        out.println();
        for (var i = 0; i < nMax; i++) {
            PrintAdv(GREEN, format("Nhập chuỗi thứ %d: ", i + 1), RESET);
            list.add(scan.next());
        }
        // selection
        PrintlnAdv(BLUE, "Phân biệt chữ hoa chữ thường?");
        PrintlnAdv("1. Có   ");
        PrintlnAdv("2. Không");
        PrintAdv("Chọn 1 trong các phương án trên: ");
        out.print(RESET);
        // output
        PrintlnAdv(YELLOW, NumLimit(1, 2) == 1 ? CheckCase(list) : CheckContent(list));
        out.println();
        // ctrl
        CheckOut();
    }

    // Check content without case
    private static String CheckContent(ArrayList<String> list) {
        // var
        var max = list.size();
        var strFrm = list.get(0).toLowerCase();
        // def
        var s = format("%d chuỗi giống nhau.", max);
        // check miss
        for (var i = 1; i < max; i++) {
            if (!list.get(i).toLowerCase().equals(strFrm)) {
                s = format("%d chuỗi khác nhau.", max);
                break;
            }
        }
        return s;
    }

    // Check case
    private static String CheckCase(ArrayList<String> list) {
        // var
        var max = list.size();
        var strFrm = list.get(0);
        // def
        var s = format("%d chuỗi giống nhau.", max);
        // check miss
        for (var i = 1; i < max; i++) {
            if (!list.get(i).equals(strFrm)) {
                s = format("%d chuỗi khác nhau.", max);
                break;
            }
        }
        return s;
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

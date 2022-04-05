package exercise_list;

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
        PrintlnAdv(BLUE_BOLD, "Input Exersice");
        // content
        Main();
    }

    // Fields
    private static final Scanner _scan = new Scanner(in);
    private static final int _nMax = 2;

    // Main
    private static void Main() {
        // var
        ArrayList<String> list = new ArrayList<>();
        // input
        out.println();
        for (var i = 0; i < _nMax; i++) {
            PrintAdv(GREEN, format("Nhập chuỗi thứ %d: ", i + 1), RESET);
            list.add(_scan.next());
        }
        // cap
        PrintlnAdv(CYAN, "Phân biệt chữ hoa chữ thường?");
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
        var strFrm = ToLowerCaseAdv(list.get(0));
        // def
        var s = format("%d chuỗi giống nhau.", max);
        // check miss
        for (var i = 1; i < max; i++) {
            if (!ToLowerCaseAdv(list.get(i)).equals(strFrm)) {
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

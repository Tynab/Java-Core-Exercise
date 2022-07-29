package exercise_list;

import java.util.*;

import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class ListExercise {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Input Exersice");
        // content
        run();
    }

    // Fields
    private static final Scanner scan = new Scanner(in);
    private static final int N_MAX = 2;

    // Main
    private static void run() {
        // input
        out.println();
        var list = new ArrayList<String>();
        for (var i = 0; i < N_MAX; i++) {
            printAdv(GREEN, format("Nhập chuỗi thứ %d: ", i + 1), RESET);
            list.add(scan.nextLine());
        }
        // cap
        printlnAdv(CYAN, "Phân biệt chữ hoa chữ thường?");
        printlnAdv("1. Có   ");
        printlnAdv("2. Không");
        printAdv("Chọn 1 trong các phương án trên: ");
        out.print(RESET);
        // output
        printlnAdv(YELLOW, numLimit(1, 2) == 1 ? checkCase(list) : checkContent(list));
        out.println();
        // ctrl
        checkOut();
    }

    // Check content without case
    private static String checkContent(List<String> list) {
        // def
        var max = list.size();
        var strFrm = toLowerCaseAdv(list.get(0)); // pin out loop
        var s = format("%d chuỗi giống nhau.", max);
        // check miss
        for (var i = 1; i < max; i++) {
            if (!toLowerCaseAdv(list.get(i)).equals(strFrm)) {
                s = format("%d chuỗi khác nhau.", max);
                break;
            }
        }
        return s;
    }

    // Check case
    private static String checkCase(List<String> list) {
        // def
        var max = list.size();
        var strFrm = list.get(0); // pin out loop
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
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

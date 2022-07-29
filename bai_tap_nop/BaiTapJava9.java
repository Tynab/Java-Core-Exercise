package bai_tap_nop;

import java.util.*;

import static java.lang.Math.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava9 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 9");
        // content
        run();
    }

    // Fields
    private static final int N_MAX = 2;
    private static final int C_MAX = 2;

    // Main
    private static void run() {
        // input
        out.println(CYAN);
        printAdv(format("Nhập số tự nhiên có %d chữ số", C_MAX));
        out.println();
        var ns = new int[N_MAX];
        for (var i = 0; i < N_MAX; i++) {
            printAdv(GREEN, format("Số thứ %d: ", i + 1), RESET);
            ns[i] = numLimit((int) pow(10, C_MAX - 1), (int) pow(10, C_MAX) - 1); // cmax=2
        }
        // output
        printlnAdv(YELLOW, format("Kết luận: %s.", checkNumContain(collectionChar(ns))));
        out.println();
        // ctrl
        checkOut();
    }

    // Collection
    private static List<String> collectionChar(int... args) {
        var list = new ArrayList<String>();
        for (var item : args) {
            var s = "";
            var str = valueOf(item);
            for (var i = 0; i < str.length(); i++) {
                s += str.charAt(i);
            }
            list.add(s);
        }
        return list;
    }

    // Check number contain in list
    private static String checkNumContain(List<String> list) {
        var res = "false";
        for (var i = 0; i < list.size() - 1; i++) {
            for (var j = i + 1; j < list.size(); j++) {
                var item = list.get(j);
                for (var k = 0; k < item.length(); k++) {
                    if (list.get(i).contains(valueOf(item.charAt(k)))) {
                        res = "true";
                        break;
                    }
                }
            }
        }
        return res;
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

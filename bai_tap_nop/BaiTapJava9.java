package bai_tap_nop;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava9 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        PrintlnAdv("Bài Tập Java 9");
        // content
        Main();
    }

    // Fields
    private static final int _nMax = 2;
    private static final int _cMax = 2;

    // Main
    private static void Main() {
        // input
        out.println(CYAN);
        PrintAdv(format("Nhập số tự nhiên có %d chữ số", _cMax));
        out.println();
        var ns = new int[_nMax];
        for (var i = 0; i < _nMax; i++) {
            PrintAdv(GREEN, format("Số thứ %d: ", i + 1), RESET);
            ns[i] = NumLimit((int) pow(10, _cMax - 1), (int) pow(10, _cMax) - 1); // cmax=2
        }
        // output
        PrintlnAdv(YELLOW, format("Kết luận: %s.", CheckNumContain(CollectionChar(ns))));
        out.println();
        // ctrl
        CheckOut();
    }

    // Collection
    private static List<String> CollectionChar(int... args) {
        List<String> list = new ArrayList<>();
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
    private static String CheckNumContain(List<String> list) {
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
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

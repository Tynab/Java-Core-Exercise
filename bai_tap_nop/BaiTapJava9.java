package bai_tap_nop;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.*;
import static java.lang.System.*;
import static java.util.stream.Stream.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava9 {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(BLUE_BOLD, "Bài Tập Java 9");
        // content
        Main();
    }

    // Fields
    private static final int _nMax = 2;
    private static final int _cMax = 2;

    // Main
    private static void Main() {
        // input
        var ns = new int[_nMax];
        out.println();
        PrintAdv(CYAN, format("Nhập số tự nhiên có %d chữ số\n", _cMax));
        for (var i = 0; i < _nMax; i++) {
            PrintAdv(GREEN, format("Số thứ %d: ", i + 1), RESET);
            ns[i] = NumLimit(10, 99); // cmax=2
        }
        // output
        PrintlnAdv(YELLOW, format("Kết luận: %s.\n", CheckNumContain(CollectionChar(ns))));
        // ctrl
        CheckOut();
    }

    // Collection
    private static List<Character[]> CollectionChar(int... args) {
        List<Character[]> list = new ArrayList<>();
        for (var item : args) {
            var cs = new Character[_cMax];
            var num = valueOf(item);
            for (var i = 0; i < num.length(); i++) {
                cs[i] = num.charAt(i);
            }
            list.add(cs);
        }
        return list;
    }

    // Check number contain in list
    private static String CheckNumContain(List<Character[]> list) {
        var res = "false";
        for (var i = 0; i < list.size() - 1; i++) {
            for (var j = i + 1; j < list.size(); j++) {
                var item = list.get(j);
                for (var k = 0; k < item.length; k++) {
                    var c = item[k];
                    if (of(list.get(i)).anyMatch(s -> s == c)) {
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

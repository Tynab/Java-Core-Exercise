package bai_tap_nop;

import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapJava1 {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(BLUE_BOLD, "Bài Tập Java 1");
        // content
        Main();
    }

    // Fields
    private static final int _rMax = 15;
    private static final int _cMax = 46;
    private static final int _rChange = 10;
    private static final int _cChange = 12;

    // Main
    private static void Main() {
        out.println();
        out.print(YELLOW);
        for (var i = 1; i <= _rMax; i++) {
            var str = "";
            if (i < _rChange) {
                for (var j = 1; j <= _cMax; j++) {
                    str += j < _cChange ? (j - i) % 2 == 0 ? "*" : " " : j == _cChange ? " " : "=";
                }
            } else {
                for (var j = 1; j <= _cMax; j++) {
                    str += "=";
                }
            }
            PrintlnAdv(str);
        }
        PrintAdv(RESET, "\n");
    }
}

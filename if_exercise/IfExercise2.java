package if_exercise;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class IfExercise2 {
    public static void main(String[] args) {
        out.println();
        PrintlnAdv(BLUE_BOLD, "If Exersice 2");
        Main();
    }

    // Main
    private static void Main() {
        out.println();
        PrintAdv(GREEN, "Nhập vào số tự nhiên: ", RESET);
        var num = CheckLimitInt(0, MAX_VALUE);
        var result = format("Số %d có %d chữ số.\n", num, NumCounter(num));
        PrintlnAdv(CYAN, result);
        CheckOut();
    }

    // Number counter
    private static int NumCounter(int num) {
        return String.valueOf(num).length();
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

package if_exercise;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class IfExercise1 {
    public static void main(String[] args) {
        out.println();
        PrintlnAdv(BLUE_BOLD, "If Exersice 1");
        Main();
    }

    // Main
    private static void Main() {
        out.println();
        PrintAdv(GREEN, "Nhập số tự nhiên thứ nhất: ", YELLOW);
        var num1 = CheckLimitInt(0, MAX_VALUE);
        PrintAdv(GREEN, "Nhập số tự nhiên thứ hai: ", YELLOW);
        var num2 = CheckLimitInt(0, MAX_VALUE);
        PrintAdv(GREEN, "Nhập số tự nhiên thứ ba: ", YELLOW);
        var num3 = CheckLimitInt(0, MAX_VALUE);
        var result = format("Kết luận: %s.\n", CheckOrder(num1, num2, num3));
        PrintlnAdv(CYAN, result);
        CheckOut();
    }

    // Check order
    private static String CheckOrder(int num1, int num2, int num3) {
        return num1 < num2 && num2 < num3 ? "xếp theo thứ tự tăng dần"
                : num1 > num2 && num2 > num3 ? "xếp theo thứ tự giảm dần" : "chưa được sắp xếp";
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

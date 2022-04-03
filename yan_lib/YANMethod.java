package yan_lib;

import java.util.Scanner;

import static java.lang.Float.*;
import static java.lang.Integer.*;
import static java.lang.System.*;
import static java.lang.String.*;
import static yan_lib.YANConstant.*;

public class YANMethod {
    // Fields
    private static Scanner scan = new Scanner(in);

    // Try parse int
    public static boolean TryParse(String str, int n) {
        var is_success = true;
        try {
            n = parseInt(str);
        } catch (Exception e) {
            is_success = false;
        }
        return is_success;
    }

    // Try parse float
    public static boolean TryParse(String str, float n) {
        var is_success = true;
        try {
            n = parseFloat(str);
        } catch (Exception e) {
            is_success = false;
        }
        return is_success;
    }

    // Scan int
    public static int ScanInt() {
        var n = 0;
        var s = scan.next();
        if (TryParse(s, n)) {
            n = parseInt(s);
        } else {
            PrintAdv(RED, "Dữ liệu bạn nhập không phải số nguyên, xin nhập lại: ", RESET);
            n = ScanInt();
        }
        return n;
    }

    // Scan float
    public static float ScanFloat() {
        var n = 0f;
        var s = scan.next();
        if (TryParse(s, n)) {
            n = parseFloat(s);
        } else {
            PrintAdv(RED, "Dữ liện bạn nhập không phải số, xin nhập lại: ", RESET);
            n = ScanFloat();
        }
        return n;
    }

    // Check ascending
    public static boolean IsAscending(int... args) {
        var is_success = true;
        for (var i = 0; i < args.length - 1; i++) {
            if (args[i] > args[i + 1]) {
                is_success = false;
                break;
            }
        }
        return is_success;
    }

    // Check descending
    public static boolean IsDescending(int... args) {
        var is_success = true;
        for (var i = 0; i < args.length - 1; i++) {
            if (args[i] < args[i + 1]) {
                is_success = false;
                break;
            }
        }
        return is_success;
    }

    // Number limit int
    public static int NumLimit(int min, int max) {
        var n = ScanInt();
        if (n < min || n > max) {
            PrintAdv(RED, "Không xác định, xin nhập lại: ", RESET);
            n = NumLimit(min, max);
        }
        return n;
    }

    // Number limit float
    public static float NumLimit(float min, float max) {
        var n = ScanFloat();
        if (n < min || n > max) {
            PrintAdv(RED, "Không xác định, xin nhập lại: ", RESET);
            n = NumLimit(min, max);
        }
        return n;
    }

    // Print advanced
    public static void PrintAdv(String s) {
        for (var i = 1; i <= (width - s.length()) / 2; i++) {
            out.print(" ");
        }
        out.print(s);
    }

    // Print advanced color
    public static void PrintAdv(String cl, String s) {
        for (var i = 1; i <= (width - s.length()) / 2; i++) {
            out.print(" ");
        }
        out.print(cl + s);
    }

    // Print advanced multi color
    public static void PrintAdv(String cl, String s, String cl_follow) {
        for (var i = 1; i <= (width - s.length()) / 2; i++) {
            out.print(" ");
        }
        out.print(cl + s + cl_follow);
    }

    // Print line advanced
    public static void PrintlnAdv(String s) {
        for (var i = 1; i <= (width - s.length()) / 2; i++) {
            out.print(" ");
        }
        out.println(s);
    }

    // Print line advanced color
    public static void PrintlnAdv(String cl, String s) {
        for (var i = 1; i <= (width - s.length()) / 2; i++) {
            out.print(" ");
        }
        out.println(cl + s);
    }

    // Print line advanced multi color
    public static void PrintlnAdv(String cl, String s, String cl_follow) {
        for (var i = 1; i <= (width - s.length()) / 2; i++) {
            out.print(" ");
        }
        out.println(cl + s + cl_follow);
    }

    // Credit
    public static int Credit() {
        PrintlnAdv(PURPLE, "Bạn có muốn tiếp tục?");
        PrintlnAdv("1. Có   ");
        PrintlnAdv("2. Không");
        PrintAdv("Chọn 1 trong các phương án trên: ");
        out.print(RESET);
        return NumLimit(1, 2);
    }

    // Convert number to UTC
    public static String NumToUTC(float n) {
        var hour = (int) n;
        var minute = (int) ((n - hour) * 60);
        return format("%s%d:%02d", n < 0 ? "GMT-" : "GMT+", hour, minute);
    }
}

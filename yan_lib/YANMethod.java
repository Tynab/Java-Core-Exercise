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
    public static boolean TryParseInt(String str, int num) {
        var check = true;
        try {
            num = parseInt(str);
        } catch (Exception e) {
            check = false;
        }
        return check;
    }

    // Try parse float
    public static boolean TryParseFloat(String str, float num) {
        var check = true;
        try {
            num = parseFloat(str);
        } catch (Exception e) {
            check = false;
        }
        return check;
    }

    // Scan int
    public static int ScanInt() {
        var num = 0;
        var str = scan.next();
        if (TryParseInt(str, num)) {
            num = parseInt(str);
        } else {
            PrintAdv(RED, "Dữ liệu bạn nhập không phải số nguyên, xin nhập lại: ", RESET);
            num = ScanInt();
        }
        return num;
    }

    // Scan float
    public static float ScanFloat() {
        var num = 0f;
        var str = scan.next();
        if (TryParseFloat(str, num)) {
            num = parseFloat(str);
        } else {
            PrintAdv(RED, "Dữ liện bạn nhập không phải số, xin nhập lại: ", RESET);
            num = ScanFloat();
        }
        return num;
    }

    // Check limit int
    public static int CheckLimitInt(int min, int max) {
        var num = ScanInt();
        if (num < min || num > max) {
            PrintAdv(RED, "Không xác định, xin nhập lại: ", RESET);
            num = CheckLimitInt(min, max);
        }
        return num;
    }

    // Check limit int
    public static float CheckLimitFloat(float min, float max) {
        var num = ScanFloat();
        if (num < min || num > max) {
            PrintAdv(RED, "Không xác định, xin nhập lại: ", RESET);
            num = CheckLimitFloat(min, max);
        }
        return num;
    }

    // Print advanced
    public static void PrintAdv(String str) {
        var padding = (width - str.length()) / 2;
        for (var i = 1; i <= padding; i++) {
            out.print(" ");
        }
        out.print(str);
    }

    // Print advanced
    public static void PrintAdv(String color, String str) {
        var padding = (width - str.length()) / 2;
        for (var i = 1; i <= padding; i++) {
            out.print(" ");
        }
        out.print(color + str);
    }

    // Print advanced
    public static void PrintAdv(String color, String str, String reset) {
        var padding = (width - str.length()) / 2;
        for (var i = 1; i <= padding; i++) {
            out.print(" ");
        }
        out.print(color + str + reset);
    }

    // Print line advanced
    public static void PrintlnAdv(String str) {
        var padding = (width - str.length()) / 2;
        for (var i = 1; i <= padding; i++) {
            out.print(" ");
        }
        out.println(str);
    }

    // Print line advanced
    public static void PrintlnAdv(String color, String str) {
        var padding = (width - str.length()) / 2;
        for (var i = 1; i <= padding; i++) {
            out.print(" ");
        }
        out.println(color + str);
    }

    // Print line advanced
    public static void PrintlnAdv(String color, String str, String reset) {
        var padding = (width - str.length()) / 2;
        for (var i = 1; i <= padding; i++) {
            out.print(" ");
        }
        out.println(color + str + reset);
    }

    // Credit
    public static int Credit() {
        PrintlnAdv(PURPLE, "Bạn có muốn tiếp tục?");
        PrintlnAdv("1. Có   ");
        PrintlnAdv("2. Không");
        PrintAdv("Chọn 1 trong các phương án trên: ");
        out.print(RESET);
        return CheckLimitInt(1, 2);
    }

    // Convert number to UTC
    public static String NumToUTC(float num) {
        var hour = (int) num;
        var minute = (int) ((num - hour) * 60);
        var header = num < 0 ? "GMT-" : "GMT+";
        return format("%s%d:%02d", header, hour, minute);
    }
}

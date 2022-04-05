package yan_lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Character.*;
import static java.lang.Float.*;
import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;

public class YANMethod {
    // Fields
    private static final Scanner _scan = new Scanner(in);

    // Parse int advanced
    public static int ParseIntAdv(Character c) {
        return parseInt(valueOf(c));
    }

    // Parse float advanced
    public static float ParseFloatAdv(Character c) {
        return parseInt(valueOf(c));
    }

    // Try parse int
    public static boolean TryParseInt(Character c) {
        var is_success = true;
        try {
            parseInt(valueOf(c));
        } catch (Exception e) {
            is_success = false;
        }
        return is_success;
    }

    // Try parse int
    public static boolean TryParseInt(String s) {
        var is_success = true;
        try {
            parseInt(s);
        } catch (Exception e) {
            is_success = false;
        }
        return is_success;
    }

    // Try parse float
    public static boolean TryParseFloat(Character c) {
        var is_success = true;
        try {
            parseFloat(valueOf(c));
        } catch (Exception e) {
            is_success = false;
        }
        return is_success;
    }

    // Try parse float
    public static boolean TryParseFloat(String s) {
        var is_success = true;
        try {
            parseFloat(s);
        } catch (Exception e) {
            is_success = false;
        }
        return is_success;
    }

    // Scan int
    public static int ScanInt() {
        var n = 0;
        var s = _scan.nextLine();
        if (TryParseFloat(s)) {
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
        var s = _scan.nextLine();
        if (TryParseFloat(s)) {
            n = parseFloat(s);
        } else {
            PrintAdv(RED, "Dữ liện bạn nhập không phải số, xin nhập lại: ", RESET);
            n = ScanFloat();
        }
        return n;
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
        for (var i = 1; i <= (WIDTH - s.length()) / 2; i++) {
            out.print(" ");
        }
        out.print(s);
    }

    // Print advanced color
    public static void PrintAdv(String cl, String s) {
        for (var i = 1; i <= (WIDTH - s.length()) / 2; i++) {
            out.print(" ");
        }
        out.print(cl + s);
    }

    // Print advanced multi color
    public static void PrintAdv(String cl, String s, String cl_follow) {
        for (var i = 1; i <= (WIDTH - s.length()) / 2; i++) {
            out.print(" ");
        }
        out.print(cl + s + cl_follow);
    }

    // Print line advanced
    public static void PrintlnAdv(String s) {
        for (var i = 1; i <= (WIDTH - s.length()) / 2; i++) {
            out.print(" ");
        }
        out.println(s);
    }

    // Print line advanced color
    public static void PrintlnAdv(String cl, String s) {
        for (var i = 1; i <= (WIDTH - s.length()) / 2; i++) {
            out.print(" ");
        }
        out.println(cl + s);
    }

    // Print line advanced multi color
    public static void PrintlnAdv(String cl, String s, String cl_follow) {
        for (var i = 1; i <= (WIDTH - s.length()) / 2; i++) {
            out.print(" ");
        }
        out.println(cl + s + cl_follow);
    }

    // Check whitespace
    public static boolean IsWhitespace(String s) {
        var is_success = true;
        for (var i = 0; i < s.length(); i++) {
            if (!isWhitespace(s.charAt(i))) {
                is_success = false;
                break;
            }
        }
        return is_success;
    }

    // Check null or empty
    public static boolean IsNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    // Check null or whitespace
    public static boolean IsNullOrWhitespace(String s) {
        return IsNullOrEmpty(s) || IsWhitespace(s);
    }

    // Covert to title case
    public static String ToTitleCase(String s) {
        List<Character> list = new ArrayList<>();
        var str = "";
        if (!IsNullOrWhitespace(s)) {
            var cst = s.charAt(0);
            cst = isWhitespace(cst) ? cst : toUpperCase(cst);
            list.add(cst);
            for (var i = 0; i < s.length() - 1; i++) {
                var c = s.charAt(i + 1);
                if (isWhitespace(s.charAt(i)) && !isWhitespace(c)) {
                    list.add(toUpperCase(c));
                } else {
                    list.add(c);
                }
            }
            for (var item : list) {
                str += item;
            }
        }
        return str;
    }

    // Convert to lower case advanced
    public static String ToLowerCaseAdv(String s) {
        return IsNullOrWhitespace(s) ? s : s.toLowerCase();
    }

    // Convert to upper case advanced
    public static String ToUpperCaseAdv(String s) {
        return IsNullOrWhitespace(s) ? s : s.toUpperCase();
    }

    // Convert to title case advanced
    public static String ToTitleCaseAdv(String s) {
        return IsNullOrWhitespace(s) ? s : ToTitleCase(s.toLowerCase());
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
}

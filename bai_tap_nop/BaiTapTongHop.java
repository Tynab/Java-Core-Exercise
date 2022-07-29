package bai_tap_nop;

import static java.lang.Integer.*;
import static java.lang.Math.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapTongHop {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Tính Tiền Karaoke");
        // content
        run();
    }

    // Field
    private static final double LIMIT_PERCENT = 30;
    private static final double DISCOUNT_PERCENT = 20;
    private static final double GIA_NUOC = 10000;
    private static final double TIEN_GIO = 30000;
    private static final double GIO_MO = 9;
    private static final double GIO_DONG = 24;
    private static final double GIO_DIS_START = 9;
    private static final double GIO_DIS_END = 17;
    private static final double SO_GIO_CHUAN = 3;

    // Main
    private static void run() {
        // input
        out.println();
        printAdv(GREEN, "Số thành viên của nhóm khách hàng: ", RESET);
        var n = numLimit(1, MAX_VALUE);
        printAdv(GREEN, "Giờ bắt đầu: ", RESET);
        var checkin = inLimit(GIO_MO, GIO_DONG);
        printAdv(GREEN, "Giờ kết thúc: ", RESET);
        var checkout = outLimit(checkin, GIO_DONG);
        // process
        var sum = tinhTienNuoc(n) + tinhTienGio(checkin, checkout);
        sum = checkin >= GIO_DIS_START && checkin <= GIO_DIS_END ? sum - sum * DISCOUNT_PERCENT / 100 : sum;
        // output
        printlnAdv(YELLOW, format("Tổng chi phí khách hàng phải trả là: %,.0f đồng.", ceil(sum)));
        out.println();
        // ctrl
        checkOut();
    }

    // Checkin limit
    private static double inLimit(double min, double max) {
        var n = scanDub();
        if (n < min || n > max) {
            printAdv(RED, format("Thời gian mở cửa từ %sh đến %sh, xin nhập lại: ", writePerfectDub(GIO_MO),
                    writePerfectDub(GIO_DONG)), RESET);
            n = inLimit(min, max);
        }
        return n;
    }

    // Checkout limit
    private static double outLimit(double min, double max) {
        var n = scanDub();
        if (n < min) {
            printAdv(RED, "Thời gian ra về không thể trước thời gian vào, xin nhập lại: ", RESET);
            n = outLimit(min, max);
        } else if (n > max) {
            printAdv(RED, format("Thời gian mở cửa từ %sh đến %sh, xin nhập lại: ", writePerfectDub(GIO_MO),
                    writePerfectDub(GIO_DONG)), RESET);
            n = outLimit(min, max);
        }
        return n;
    }

    // Tính tiền nước uống của nhóm khách hàng
    private static double tinhTienNuoc(int n) {
        return n * GIA_NUOC;
    }

    // Tính tiền giờ của nhóm khách hàng
    private static double tinhTienGio(double checkin, double checkout) {
        var tong_gio = checkout - checkin;
        return tong_gio > SO_GIO_CHUAN
                ? (SO_GIO_CHUAN + (tong_gio - SO_GIO_CHUAN) * LIMIT_PERCENT / 100) * TIEN_GIO
                : tong_gio * TIEN_GIO;
    }

    // Check out
    private static void checkOut() {
        if (credit() == 1) {
            run();
        }
    }
}

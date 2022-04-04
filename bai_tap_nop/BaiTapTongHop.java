package bai_tap_nop;

import static java.lang.Integer.*;
import static java.lang.Math.*;
import static java.lang.String.*;
import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class BaiTapTongHop {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(CYAN_BOLD, "Tính Tiền Karaoke");
        // content
        Main();
    }

    // Field
    private static final int _limit_percent = 30;
    private static final int _discount_percent = 20;
    private static final int _gia_nuoc = 10000;
    private static final int _tien_gio = 30000;
    private static final int _gio_discount_start = 9;
    private static final int _gio_discount_end = 17;
    private static final int _so_gio_chuan = 3;

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(GREEN, "Số thành viên của nhóm khách hàng: ", RESET);
        var n = NumLimit(1, MAX_VALUE);
        PrintAdv(GREEN, "Giờ bắt đầu: ", RESET);
        var checkin = InLimit(9, 24);
        PrintAdv(GREEN, "Giờ kết thúc: ", RESET);
        var checkout = OutLimit(checkin, 24);
        // process
        var sum = TinhTienNuoc(n) + TinhTienGio(checkin, checkout);
        sum = checkin >= _gio_discount_start && checkin <= _gio_discount_end ? sum - sum * _discount_percent / 100 : sum;
        // output
        PrintlnAdv(YELLOW, format("Tổng chi phí khách hàng phải trả là: %,.0f đồng.\n", ceil(sum)));
        // ctrl
        CheckOut();
    }

    // Number limit float
    private static float InLimit(float min, float max) {
        var n = ScanFloat();
        if (n < min || n > max) {
            PrintAdv(RED, "Thời gian mở cửa từ 9h đến 24h, xin nhập lại: ", RESET);
            n = InLimit(min, max);
        }
        return n;
    }

    // Number limit float
    private static float OutLimit(float min, float max) {
        var n = ScanFloat();
        if (n < min) {
            PrintAdv(RED, format("Thời gian ra về không thể trước thời gian vào, xin nhập lại: "), RESET);
            n = OutLimit(min, max);
        } else if (n > max) {
            PrintAdv(RED, "Thời gian mở cửa từ 9h đến 24h, xin nhập lại: ", RESET);
            n = OutLimit(min, max);
        }
        return n;
    }

    // Tính tiền nước uống của nhóm khách hàng
    private static int TinhTienNuoc(int n) {
        return n * _gia_nuoc;
    }

    // Tính tiền giờ của nhóm khách hàng
    private static float TinhTienGio(float checkin, float checkout) {
        var tong_gio = checkout - checkin;
        return tong_gio > 3 ? (_so_gio_chuan + (tong_gio - _so_gio_chuan) * _limit_percent / 100) * _tien_gio
                : tong_gio * _tien_gio;
    }

    // Check out
    private static void CheckOut() {
        if (Credit() == 1) {
            Main();
        }
    }
}

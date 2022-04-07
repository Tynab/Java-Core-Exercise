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
        out.println(BLUE_BOLD);
        PrintlnAdv("Tính Tiền Karaoke");
        // content
        Main();
    }

    // Field
    private static final double _limit_percent = 30;
    private static final double _discount_percent = 20;
    private static final double _gia_nuoc = 10000;
    private static final double _tien_gio = 30000;
    private static final double _gio_mo = 9;
    private static final double _gio_dong = 24;
    private static final double _gio_dis_start = 9;
    private static final double _gio_dis_end = 17;
    private static final double _so_gio_chuan = 3;

    // Main
    private static void Main() {
        // input
        out.println();
        PrintAdv(GREEN, "Số thành viên của nhóm khách hàng: ", RESET);
        var n = NumLimit(1, MAX_VALUE);
        PrintAdv(GREEN, "Giờ bắt đầu: ", RESET);
        var checkin = InLimit(_gio_mo, _gio_dong);
        PrintAdv(GREEN, "Giờ kết thúc: ", RESET);
        var checkout = OutLimit(checkin, _gio_dong);
        // process
        var sum = TinhTienNuoc(n) + TinhTienGio(checkin, checkout);
        sum = checkin >= _gio_dis_start && checkin <= _gio_dis_end ? sum - sum * _discount_percent / 100 : sum;
        // output
        PrintlnAdv(YELLOW, format("Tổng chi phí khách hàng phải trả là: %,.0f đồng.", ceil(sum)));
        out.println();
        // ctrl
        CheckOut();
    }

    // Checkin limit
    private static double InLimit(double min, double max) {
        var n = ScanDub();
        if (n < min || n > max) {
            PrintAdv(RED, format("Thời gian mở cửa từ %sh đến %sh, xin nhập lại: ", WritePerfectDub(_gio_mo),
                    WritePerfectDub(_gio_dong)), RESET);
            n = InLimit(min, max);
        }
        return n;
    }

    // Checkout limit
    private static double OutLimit(double min, double max) {
        var n = ScanDub();
        if (n < min) {
            PrintAdv(RED, "Thời gian ra về không thể trước thời gian vào, xin nhập lại: ", RESET);
            n = OutLimit(min, max);
        } else if (n > max) {
            PrintAdv(RED, format("Thời gian mở cửa từ %sh đến %sh, xin nhập lại: ", WritePerfectDub(_gio_mo),
                    WritePerfectDub(_gio_dong)), RESET);
            n = OutLimit(min, max);
        }
        return n;
    }

    // Tính tiền nước uống của nhóm khách hàng
    private static double TinhTienNuoc(int n) {
        return n * _gia_nuoc;
    }

    // Tính tiền giờ của nhóm khách hàng
    private static double TinhTienGio(double checkin, double checkout) {
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

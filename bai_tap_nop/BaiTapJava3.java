package bai_tap_nop;

import static java.lang.String.*;
import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class BaiTapJava3 {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Bài Tập Java 3");
        // content
        run();
    }

    // Fields
    private static final String[] mKey = {
            "java.version",
            "java.version.date",
            "java.vendor",
            "java.vendor.url",
            "java.vendor.version",
            "java.home",
            "java.vm.specification.version",
            "java.vm.specification.vendor",
            "java.vm.specification.name",
            "java.vm.version",
            "java.vm.vendor",
            "java.vm.name",
            "java.specification.version",
            "java.specification.vendor",
            "java.specification.name",
            "java.class.version",
            "java.io.tmpdir",
            "java.compiler",
            "os.name",
            "os.arch",
            "os.version",
            "file.separator",
            "path.separator",
            "user.name",
            "user.home",
            "user.dir"
    };

    // Main
    private static void run() {
        out.println(YELLOW);
        for (var item : mKey) {
            out.println(format("\t・%s: %s", toLowerCaseAdv(item.replace('.', ' ')), getProperty(item)));
        }
        out.println(RESET);
    }
}

package exercise_output;

import static java.lang.System.*;
import static yan_service.YANConstant.*;
import static yan_service.YANService.*;

public class OutputExercise {
    public static void main(String[] args) {
        // tit
        out.println(BLUE_BOLD);
        printlnAdv("Output Exersice");
        // content
        run();
    }

    // Main
    private static void run() {
        out.println();
        out.print(YELLOW);
        printlnAdv("    J    A   V     V   A   ");
        printlnAdv("    J   A A   V   V   A A  ");
        printlnAdv("J   J  AAAAA   V V   AAAAA ");
        printlnAdv(" JJJ  A     A   V   A     A");
        out.println(RESET);
    }
}
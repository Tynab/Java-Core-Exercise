package exercise_output;

import static java.lang.System.*;
import static yan_lib.YANConstant.*;
import static yan_lib.YANMethod.*;

public class OutputExercise {
    public static void main(String[] args) {
        // tit
        out.println();
        PrintlnAdv(BLUE_BOLD, "Output Exersice");
        // content
        Main();
    }

    // Main
    private static void Main() {
        out.println();
        out.print(YELLOW);
        PrintlnAdv("    J    A   V     V   A   ");
        PrintlnAdv("    J   A A   V   V   A A  ");
        PrintlnAdv("J   J  AAAAA   V V   AAAAA ");
        PrintlnAdv(" JJJ  A     A   V   A     A");
        PrintAdv(RESET, "\n");
    }
}
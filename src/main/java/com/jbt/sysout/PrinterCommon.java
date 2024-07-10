package com.jbt.sysout;

public class PrinterCommon {
    
    public static void printSeparator() {
        System.out.println("\n<<>><<>><<>><<>><<>><<>><<>><<>>\n");
    }

    public static void clearScreen() {

        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
        
    }

}

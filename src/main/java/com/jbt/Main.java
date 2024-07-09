package com.jbt;

import com.jbt.db.Config;
import com.jbt.sysout.PrinterCommon;
import com.jbt.sysout.menus.MenuMain;

public class Main {

    public static void main(String[] args) {

        PrinterCommon.clearScreen();

        Config.initConfig();

        MenuMain.displayMainMenu();
        
        MenuMain.displayExitMessage();

    }

}
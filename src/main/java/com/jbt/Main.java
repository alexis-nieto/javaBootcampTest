package com.jbt;

import com.jbt.db.Config;
import com.jbt.sysout.menus.MenuMain;

public class Main {

    public static void main(String[] args) {

        Config.initConfig();

        MenuMain.displayMainMenu();
        
        MenuMain.displayExitMessage();

    }

}
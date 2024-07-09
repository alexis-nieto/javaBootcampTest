package com.jbt;

import com.jbt.db.Config;
import com.jbt.sysout.menus.MenuMain;

public class Main {
	
	public static void main(String[] args) {
		
		//System.out.println("Starting Book Management Application...");

		// Bootstrap config file.		
		Config.initConfig();

		// Star the main menu
		MenuMain.displayMainMenu();

		// Bye!
		MenuMain.displayExitMessage();

	}

}

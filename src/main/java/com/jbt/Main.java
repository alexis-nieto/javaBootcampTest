package com.jbt;

import com.jbt.db.Config;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Starting Book Management Application...");
		
		Config.initConfig();

		MainTests.test_addBook();
		MainTests.test_updateBook();

	}

}

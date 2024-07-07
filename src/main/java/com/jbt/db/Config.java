package com.jbt.db;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public abstract class Config {

    // Path to %LOCALAPPDATA%/lms/config.json
    private static final Path CONFIG_PATH = Paths.get(
        System.getProperty("user.home"),
        "AppData",
        "Local",
        "lms",
        "config.json"
    );

    private static Path getPath(){
        return CONFIG_PATH;
    }

    private static String getPathAsString(){
        return CONFIG_PATH.toString();
    }


    // Initialize the folder and JSON on CONFIG_PATH
    public static void initConfig (){
        try {

            // Create the directory if it doesn't exist
            Path parentPath = getPath().getParent();
            if ( !Files.exists(parentPath) ) Files.createDirectories(parentPath);
            parentPath = null; // Clear path object.

        } catch (IOException e) {
            System.out.println("An error occurred while creating %LOCALAPPADATA%/lms directory.");
            e.printStackTrace();
        }

        try {

            // Create the file if it doesn't exist
            if ( !Files.exists(getPath()) ) Files.createFile(getPath());

        } catch (IOException e) {
            System.out.println("An error occurred while creating the JSON datafile on %appdata%/local");
            e.printStackTrace();
        }

        // Try-with-resources to close the BufferedWriter
        try (BufferedWriter writer = Files.newBufferedWriter(getPath(), StandardOpenOption.WRITE)) {

            if(Files.size(getPath()) == 0){
                
                StringBuilder jsonSkeleton = new StringBuilder();
                jsonSkeleton.append("{\n");
                jsonSkeleton.append("\t\"database_url\": \"url_here\",\n");
                jsonSkeleton.append("\t\"database_name\": \"db_here\",\n");
                jsonSkeleton.append("\t\"username\": \"username_here\",\n");
                jsonSkeleton.append("\t\"password\": \"password_here\"\n");
                jsonSkeleton.append("}");
                writer.write(jsonSkeleton.toString());
                jsonSkeleton = null; // Clear StringBuilder object

            } else {
                System.out.println("JSON file already contains data, skipping init...");
            }

        } catch (IOException e) {
            System.out.println("An error occurred while writing the JSON skeleton to the file.");
            e.printStackTrace();
        }


    }

    public static String getConfig(String key) {
        try {

            JSONParser parser = new JSONParser();
            Object object = parser.parse(new FileReader(getPathAsString()));
            JSONObject jsonObject = (JSONObject) object;

            switch (key) {
                case "database_url":
                    String database_url = (String) jsonObject.get("database_url");
                    return database_url;

                case "database_name":
                    String database_name = (String) jsonObject.get("database_name");
                    return database_name;

                case "username":
                    String username = (String) jsonObject.get("username");
                    return username;

                case "password":
                    String password = (String) jsonObject.get("password");
                    return password;

                default:
                    throw new IllegalArgumentException("Invalid configuration key: " + key);
            }

        } catch(IOException | ParseException e) {
            System.out.println("An error occurred while reading the configuration file.");
            e.printStackTrace();
            return null;
        }

    }

}
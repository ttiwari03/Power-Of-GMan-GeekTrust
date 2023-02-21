package com.example.geektrust;

import com.example.geektrust.Command.CommandInvoker;
import com.example.geektrust.Config.AppConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
   
    public static void main(String[] args) {
        try {
            String filePath = args[0];
            run(filePath);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    
    private static void run(String filePath) {
        AppConfig appConfig = new AppConfig();
        CommandInvoker commandInvoker = appConfig.getCommandInvoker();
        Scanner inputScanner = null;
        try {
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            inputScanner = new Scanner(fileInputStream);
            while (inputScanner.hasNextLine()) {
                commandInvoker.execute(inputScanner.nextLine().split(" "));
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        } finally {
            if (inputScanner != null) {
                inputScanner.close();
            }
        }
    }
}

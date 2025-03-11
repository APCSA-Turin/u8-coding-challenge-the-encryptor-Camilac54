package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    
    public static int determineColumns(int messageLen, int rows){
        int cols = 0;
        while (cols * rows < messageLen) {
            cols ++;
            // System.out.println(cols + "-"); // testing
        }

        if (messageLen == 0) {
            cols = 1;
        }
        return cols;
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        int cols = determineColumns(message.length(), rows) ;
        String[][] string = new String[rows][cols];
        int i = 0;
            for (int row = 0; row < rows; row ++) {
                for (int col = 0; col < cols; col ++) {
                    if (i < message.length()) {
                        string[row][col] = message.substring(i, i + 1);
                        // System.out.print(string[row][col].toString() + "..."); // testinh
                        i ++;
                    } else {
                        string[row][col] = "=";
                        // System.out.print(string[row][col].toString() + "///"); // testing
                    }
                }
            }
        return string;
    }

    public static String encryptMessage(String message, int rows) {       
        String[][] encrypted = generateEncryptArray(message, rows);
        String str = "";
        
        for (int col = encrypted[0].length - 1; col >= 0; col --) {
            for (int row = 0; row < rows; row ++) {
                str += encrypted[row][col];
                // System.out.println(str + "   FINAL"); // testing 
            }
        }
        return str;
    }
    

    public static String decryptMessage(String encryptedMessage, int rows) {
        String str = "";
        int columns = determineColumns(encryptedMessage.length(), rows);
        System.out.println(columns);
        int i = 0;
        String [][] message = new String[rows][columns];

        for (int col = columns - 1; col >= 0; col --) {
            for (int row = 0; row < rows; row ++) {
                if (i < encryptedMessage.length()) {
                    message[row][col] = encryptedMessage.substring(i, i + 1);
                    i ++;
                    // System.out.print(message[row][col]); // testing
                }
            }
        }

        for (int row = 0; row < rows; row ++) {
            for (int col = 0; col < columns; col ++) {
                if (!(message[row][col] == null) && !message[row][col].equals("=")) {
                    str += message[row][col];
                    // System.out.println(str); // testing
                }
            }
        }
        return str;
    }
}
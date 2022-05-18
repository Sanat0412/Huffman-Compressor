/*   Created by IntelliJ IDEA.
 *   Author: Sanat Kumar Dubey (sanat04)
 *   Date: 18-05-2022
 *   Time: 11:41
 *   File: IO.java
 */

package Util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/*
Contains methods to interact with files.
 */

public class IO {
    // Inputs path of the file and returns the content of the file as string
    public static String read(String path) {
        StringBuilder message = null;
        try (FileReader fileReader = new FileReader(path)) {
            message = new StringBuilder();
            int line;
            while ((line = fileReader.read()) != -1) message.append((char) line);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return message.toString();
    }

    // Inputs string message that needs to be written in the file and the path where file need to be saved.
    public static void write(String message, String path) {
        File file = new File(path);
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (char ch : message.toCharArray()) {
                fileWriter.write(ch);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}



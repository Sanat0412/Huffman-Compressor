/*   Created by IntelliJ IDEA.
 *   Author: Sanat Kumar Dubey (sanat04)
 *   Date: 18-05-2022
 *   Time: 11:41
 *   File: Util.java
 */

package Util;

import java.io.*;

/*
Utility class with methods to save,retrieve,compress and decompress messages.
 */
public class Util {

    // Serializes object of CompressedFile and saves it to the specified path
    public static void serializeFile(CompressedFile file, String path) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(file);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    // Deserializes file from the specified path and returns object of CompressedFile type
    public static CompressedFile deserializeFile(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (CompressedFile) objectInputStream.readObject();
    }

    // Converts binary string io bit stream as string(sequence of 2-bytes character)
    public static String compress(String message) {
        StringBuilder compressedMessage = new StringBuilder();
        StringBuilder byteStream = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (byteStream.length() == 16) {
                compressedMessage.append(bitstreamToCharacter(byteStream.toString()));
                byteStream = new StringBuilder();
            }
            byteStream.append(ch);
        }
        if (byteStream.length() != 0) compressedMessage.append(bitstreamToCharacter(byteStream.toString()));
        return compressedMessage.toString();
    }

    // Converts binary string of length 16 to integer and returns it as a character
    private static char bitstreamToCharacter(String bitStream) {
        int res = Integer.valueOf(bitStream, 2) << (16 - bitStream.length());
        return (char) res;
    }

    // Converts string representation(sequence of 2-bytes character) of bit stream to binary string
    public static String decompress(String message) {
        StringBuilder decompressedMessage = new StringBuilder();
        for (char ch : message.toCharArray()) {
            decompressedMessage.append(characterToBitstream(ch));
        }
        return decompressedMessage.toString();
    }

    // Converts 16-bit character to its binary representation
    public static String characterToBitstream(char ch) {
        StringBuilder res = new StringBuilder(Integer.toBinaryString(ch));
        while (res.length() < 16) {
            res.insert(0, "0");
        }
        return res.toString();
    }

}



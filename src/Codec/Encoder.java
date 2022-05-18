package Codec;

import com.google.common.collect.BiMap;

public class Encoder {
    // Inputs message,encodes it using huffman table then return encoded message
    public static String encode(String message, BiMap<Character, String> huffmanTable) {
        StringBuilder encodedMessage = new StringBuilder();
        for (char ch : message.toCharArray()) {
            encodedMessage.append(huffmanTable.get(ch));
        }
        return encodedMessage.toString();
    }
}
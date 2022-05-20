/*   Created by IntelliJ IDEA.
 *   Author: Sanat Kumar Dubey (sanat04)
 *   Date: 18-05-2022
 *   Time: 11:39
 *   File: CompressedFile.java
 */

package Util;

import com.google.common.collect.BiMap;

import java.io.Serializable;

/*
This class binds encoded message, its huffman table as well as length of the original
message together,so that everything needed in order to decompress can be easily retrieved
from a single file.

This is the class whose object will be serialized as a compressed(output) file.
 */

    public class CompressedFile implements Serializable {
        BiMap<Character, String> huffmanTable; // Stores huffman table which can be used to decode the message later
        String message; // Stores encoded message
        int length; // Stores size(characters) of the original message

        public CompressedFile(BiMap<Character, String> huffmanTable, String message, int length) {
            this.huffmanTable = huffmanTable;
            this.message = message;
            this.length = length;
        }
        public BiMap<Character, String> getHuffmanTable() {
            return this.huffmanTable;
        }

        public String getMessage() {
            return this.message;
        }

        public int getLength() {
            return this.length;
        }
    }

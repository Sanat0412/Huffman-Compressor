/*   Created by IntelliJ IDEA.
 *   Author: Sanat Kumar Dubey (sanat04)
 *   Date: 18-05-2022
 *   Time: 11:43
 *   File: HuffmanTable.java
 */

package Huffman;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
Consists of all the methods required in order to create Huffman table.

This class uses a Bidirectional-map in order to represent Huffman table
which can be used for both encoding and decoding purposes.
 */

public class HuffmanTable {
    // Takes message as input, processes it to create huffman table and then return the table
    public static BiMap<Character, String> makeTable(String message) {
        // Create frequency table
        HashMap<Character, Integer> frequencyTable = new HashMap<>();
        for (char ch : message.toCharArray()) {
            frequencyTable.put(ch, frequencyTable.getOrDefault(ch, 0) + 1);
        }

        // Create priority queue(min-heap) based on the frequency of characters present in the message
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();

        // Fill priority queue with HuffmanNodes for every character in message
        for (char key : frequencyTable.keySet()) {
            pq.offer(new HuffmanNode(key, frequencyTable.get(key)));
        }

        // Building Huffman tree
        while (pq.size() > 1) {
            HuffmanNode min1 = pq.poll(); // node with minimum frequency among all the nodes
            HuffmanNode min2 = pq.poll(); // node with second most minimum frequency among all the nodes
            assert min2 != null;
            pq.offer(new HuffmanNode('\0', min1.frequency + min2.frequency, min1, min2));
        }

        // Initializing the Root of Huffman tree
        HuffmanNode root = pq.poll();

        // Create and save huffman table
        BiMap<Character, String> huffmanTable = HashBiMap.create(); // Initialization of huffman table
        assert root != null;
        traverseHuffmanTree(root, "", huffmanTable); // Populate huffman table

        // Return huffman table
        return huffmanTable;
    }

    // Traverses huffman tree to fill huffman table
    public static void traverseHuffmanTree(HuffmanNode node, String characterSet, BiMap<Character, String> huffmanTable) {
        if (node.left == null && node.right == null) { // Add leaf node to huffman table
            huffmanTable.put(node.value, characterSet);
            return;
        }
        assert node.left != null;
        traverseHuffmanTree(node.left, characterSet + "0", huffmanTable); // DFS to left of the current node
        traverseHuffmanTree(node.right, characterSet + "1", huffmanTable); // DFS to right of the current node
    }
}


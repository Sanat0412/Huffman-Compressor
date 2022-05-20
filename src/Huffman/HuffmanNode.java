/*   Created by IntelliJ IDEA.
 *   Author: Sanat Kumar Dubey (sanat04)
 *   Date: 18-05-2022
 *   Time: 11:42
 *   File: HuffmanNode.java
 */

package Huffman;

class HuffmanNode implements Comparable<HuffmanNode> {
    char value; // Stores character which this node represents
    int frequency; // Stores frequency of this character
    HuffmanNode left; // Pointer to the left child
    HuffmanNode right; // Pointer to the right child

    public HuffmanNode(char value, int frequency) {
        this.value = value;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public HuffmanNode(char value, int frequency, HuffmanNode left, HuffmanNode right) {
        this.value = value;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}



package workHuffman;

public class Tree {
    char symbol;
    int freq;
    Tree left = null, right = null;

    Tree(char symbol_, int freq_) {
        symbol = symbol_;
        freq = freq_;
    }

    Tree(char symbol_, int freq_, Tree left_, Tree right_) {
        symbol = symbol_;
        freq = freq_;
        left = left_;
        right = right_;
    }
}
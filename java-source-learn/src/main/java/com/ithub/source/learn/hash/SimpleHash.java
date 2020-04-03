package com.ithub.source.learn.hash;

public class SimpleHash {
    private int cap;
    private int seed;

    public SimpleHash(int cap, int seed) {
        this.cap = cap;
        this.seed = seed;
    }

    public int hash(String value) {
        int result = 0;
        int len = value.length();
        for (int i = 0; i < len; i++) {
            result = seed * result + value.charAt(i);
        }
        return (cap - 1) & result;
    }

    public static void main(String[] args) {
        SimpleHash simpleHash = new SimpleHash(2 << 12, 8);
        System.out.println("node_number=hash(\"semlinker\") % 3 -> "+simpleHash.hash("semlinker") +": "+
                simpleHash.hash("semlinker") % 3);
        System.out.println("node_number=hash(\"kakuqo\") % 3 -> "+simpleHash.hash("kakuqo") +": "+
                simpleHash.hash("kakuqo") % 3);
        System.out.println("node_number=hash(\"test\") % 3 -> "+simpleHash.hash("test") +": "+
                simpleHash.hash("test") % 3);
    }
}

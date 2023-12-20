package org.example;

public class duck {
    private static int duck_count=0;
    int size=0;
    public duck(){duck_count++;}
    public int getDuck_count() {
        this.size++;
        return duck_count;
    }
    static {duck_count++;}
}
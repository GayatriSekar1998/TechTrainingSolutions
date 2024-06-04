package com.java.hashing;

public class HashingBasicProgram {
    static int[] arr = {1,7,20,15,100};
    static int[] hash = new int[7];// {7,15,100,,,,20}
    //store inside hash table keep hash table size is prime
    public static void main(String[] args) {
        for(int i = 0;i<arr.length;i++) {
            int hindex= arr[i]%7;
            hash[hindex] = arr[i];
        }
        int key=15;
        System.out.println(" "+hash[key%7]);
    }

}
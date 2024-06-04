package com.java.hashing;

//table = (ele +i) % 13;
public class QuadraticProbing {
    static int[] arr = {14,27,17,30,19,12};
    static int[] hashtable = new int[13];


    public static void main(String[] args) {
        for(int i=0;i<arr.length;i++) {
            insertHashTable(arr[i],hashtable,13,0);
        }
        print();
        int key=17;
        fetchHashTable(key,hashtable,13,0);
    }

    private static void fetchHashTable(int key, int[] hashtable, int hashsize,int i) {

        int hashI = (key + i*i) % hashsize;
        if(hashtable[hashI] == key) {
            System.out.print("Fetch the element");
            return;
        }
        fetchHashTable(key,hashtable,hashsize,i+1);
    }

    private static void insertHashTable(int ele, int[] hashtable, int hashsize, int i) {
        int hashIndex = (ele+i*i) % hashsize;//
        if(hashtable[hashIndex] == 0) {//
            hashtable[hashIndex] = ele;
            return;
        }
        insertHashTable(ele,hashtable,hashsize,i+1);//27
    }

    private static void print() {
        for(int i=0;i<hashtable.length;i++) {
            System.out.print(" "+hashtable[i]);
        }
        System.out.println();
    }
}
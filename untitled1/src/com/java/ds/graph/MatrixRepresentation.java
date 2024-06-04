package com.java.ds.graph;

public class MatrixRepresentation {

    static int noOfVertices = 4;
    static void init(int arr[][]) {
        int i, j;
        for (i = 0; i < noOfVertices; i++)
            for (j = 0; j < noOfVertices; j++)
                arr[i][j] = 0;
    }

    /* function to add edges to the graph */
    static void insertEdge(int arr[][], int i, int j) {
        arr[i][j] = 1;
        arr[j][i] = 1;
    }

    /* function to print the matrix elements */
    static void printAdjMatrix(int arr[][]) {
        int i, j;
        for (i = 0; i < noOfVertices; i++) {
            System.out.print(" "+i+":");
            for (j = 0; j < noOfVertices; j++) {
                System.out.print(" "+arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int adjMatrix[][] = new int[4][4];

        init(adjMatrix);
        insertEdge(adjMatrix, 0, 1);
        insertEdge(adjMatrix, 0, 2);
        insertEdge(adjMatrix, 1, 2);
        insertEdge(adjMatrix, 2, 0);
        insertEdge(adjMatrix, 2, 3);

        printAdjMatrix(adjMatrix);
    }
}
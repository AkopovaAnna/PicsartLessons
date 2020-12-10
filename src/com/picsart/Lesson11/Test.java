package com.picsart.Lesson11;

public class Test {

    public static void main(String[] args) {
        BinarySearchTreeImpl binarySearch = new BinarySearchTreeImpl();

        binarySearch.insert(15);
        binarySearch.insert(1);
        binarySearch.insert(2);
        binarySearch.insert(25);
        binarySearch.insert(35);
        binarySearch.insert(3);
        binarySearch.insert(0);
        binarySearch.insert(10);

        //depthFirstSearch
        System.out.println("depth First Search");

        //breadth first search
        System.out.println("breadth first search");
        binarySearch.bfs();

        System.out.println("************************");
        System.out.println(binarySearch.findMin());
        System.out.println(binarySearch.findMax());
        System.out.println(binarySearch.contains(10));
        System.out.println(binarySearch.contains(100));
        binarySearch.delete(100);
        binarySearch.delete(25);
        binarySearch.delete(2);

        System.out.println(binarySearch.printTree());

    }
}

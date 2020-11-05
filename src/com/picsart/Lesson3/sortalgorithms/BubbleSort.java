package com.picsart.Lesson3.sortalgorithms;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {2,2,1,-1,1,0,3,1};
        bubbleSort(array);

        for (int x : array) {
            System.out.print(x + " ");
        }

    }


    public static void swap(int[] array, int i, int j) {

        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;

    }


    public static void bubbleSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    swap(array, j, j + 1);
                }
            }

        }
    }
}

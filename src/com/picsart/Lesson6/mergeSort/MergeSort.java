package com.picsart.Lesson6.mergeSort;

public class MergeSort {

    public static void main(String[] args) {

        int[] array1 = {3, 6, 1, 9, 5, 3};
        int[] array2 = {3, 1, 1, 0, 5, 7, 0};

        int[] sortedArray1 = mergeSort(array1);
        int[] sortedArray2 = mergeSort(array2);

        for (int i : sortedArray1) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i : sortedArray2) {
            System.out.print(i + " ");
        }

    }

    public static int[] mergeSort(int[] array) {

        if (array.length <= 1) {
            return array;
        }

        int middle = array.length / 2;

        int[] left = new int[middle];
        int[] right = new int[array.length - middle];


        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = array[i + middle];
        }

        int[] result;

        left = mergeSort(left);
        right = mergeSort(right);

        result = merge(left, right);

        return result;
    }

    public static int[] merge(int[] array1, int[] array2) {

        int[] result = new int[array1.length + array2.length];
        int pointer1 = 0;
        int pointer2 = 0;
        int resultIndex = 0;

        while (pointer1 < array1.length || pointer2 < array2.length) {
            if (pointer1 < array1.length && pointer2 < array2.length) {
                if (array1[pointer1] <= array2[pointer2]) {
                    result[resultIndex++] = array1[pointer1++];
                } else {
                    result[resultIndex++] = array2[pointer2++];
                }
            } else if (pointer1 < array1.length) {
                result[resultIndex++] = array1[pointer1++];
            } else if (pointer2 < array2.length) {
                result[resultIndex++] = array2[pointer2++];
            }

        }

        return result;
    }

}

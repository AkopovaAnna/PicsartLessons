package com.picsart.Lesson2;

public class Arrays {

    public static void main(String[] args) {
        System.out.println("Task1: Create an array and fill it with 2 number.");

        //solution1
        int[] arrayOfTwos1 = new int[4];
        for (int i = 0; i < arrayOfTwos1.length; i++) {
            arrayOfTwos1[i] = 2;
            System.out.print(arrayOfTwos1[i] + " ");
        }
        //solution2
        int[] arrayOfTwos2 = new int[]{2,2,2,2,2};


        System.out.println("\nTask2: Create an array and fill it with numbers from 1:1000.");
        int num = 1000;
        int[] arrayOfIntegers = new int[num];
        for (int i = 0; i < num; i++) {
            arrayOfIntegers[i] = i + 1;
            System.out.print(arrayOfIntegers[i] + " ");
        }

        System.out.println("\nTask3: Create an array and fill it with odd numbers from -20:20");
        int min = -20;
        int max = 20;

        int absMin = absValue(min);
        int absMax = absValue(max);
        int numOfElements = (absMax + absMin)/2;
        int count = 0;
        int[] arrayOfOdds = new int[numOfElements];

        for (int i = -20; i <= 20; i++) {
            if (i % 2 != 0) {
                arrayOfOdds[count] = i;
                count++;
            }
        }

        for (int i = 0; i < numOfElements; i++) {
            System.out.print(arrayOfOdds[i] + " ");

        }

        System.out.println("\nTask4: Create an array and fill it. Print all elements which can be divided by 5.");

        int[] numberDividedByFive = {6, 14, 78, 34, 55, 125};

        for (int i = 0; i < numberDividedByFive.length; i++) {
            if (numberDividedByFive[i] % 5 == 0) {
                System.out.print(numberDividedByFive[i] + " ");
            }

        }

        System.out.println("\nTask5: Create an array and fill it. Print all elements which are between 24.12 and 467.23.");

        double[] numbers = {34, 12.4, 23.2, 45, 500};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= 24.12 && numbers[i] <= 467.23) {

                System.out.print(numbers[i] + " ");
            }

        }

        System.out.println("\nTask6: Create an array and fill it. Print count of elements which can be divided by 2.");

        int[] dividedByTwo = {5, 12, 4, 3, 45, 55};
        count = 0;
        for (int i = 0; i < dividedByTwo.length; i++) {
            if (dividedByTwo[i] % 2 == 0) {
                count++;
            }
        }
        System.out.println("count of elements divided by 2: " + count);


        System.out.println("\nTask 7: print its first 10 multiples.");
        multiplication(2);


    }

    public static void multiplication(int n) {
        if (n > 0 && n < 21) {
            for (int j = 1; j < 11; j++) {
                System.out.println(n + " * " + j + " = " + (n * j));
            }
        } else {
            System.out.println("out of range");
        }

    }

    public static int absValue(int num) {
        return num < 0 ? -num : num;
    }

}


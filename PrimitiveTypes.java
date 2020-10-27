package com.picsart.Lesson1;

public class PrimitiveTypes {

    public static void main(String[] args) {
        int a = 128;
        int a1 = '1';
//        int a2 = "2";
        System.out.println("a = " + a);
        System.out.println("a1 = " + a1);


        byte b = 127;
        byte b1 = (byte) (b + a);
        System.out.println("b = " + b);
        System.out.println("b1 = " + b1);

        long l = 234829734932749L;
        System.out.println("l = " + l);
        long l1 = 234;
        System.out.println("l1 = " + l1);

        short s = 33;
        System.out.println("s = " + s);


        int i = 15/2;
        float f = 3;
        float f1 = 4F;
        System.out.println(f +  f1);
        System.out.println(a + f);
        System.out.println(i + f);

        double d = 4;
        double d1 = 34.879879D;
        System.out.println("d = " + d + " ; d1 = " + d1);

        char c = 'A';
        System.out.println("c = " + c);
        System.out.println("char + int = " + (c + a));

        boolean isPrimitive = true;
        System.out.println(!isPrimitive);


    }
}

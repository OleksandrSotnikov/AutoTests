package com.autotests.TestCase;

public class Tests {
    public static int sum(int a, int b) {
//        return 42;
        System.out.println(a);
        return a;
    }

    public static String test(String a, String b) {
        return a + " " + b;
    }

    public static void echo (String a, String b){
        String out = a.toUpperCase()+ " "+b.toUpperCase();

        System.out.println(out);
    }

    public static void main(String[] args) {
        String h = new String("123456789");
        String w = "World";
        System.out.println("2+3 = ");

        int summary = sum(2, 3);
        System.out.println(summary);
        System.out.println(test(h, w));
        System.out.println("tadah!");
        echo("Test","Hello" );
    }
}

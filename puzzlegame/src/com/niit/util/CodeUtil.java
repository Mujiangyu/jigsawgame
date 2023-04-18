package com.niit.util;

import java.util.ArrayList;
import java.util.Random;

public class CodeUtil {

    private CodeUtil(){}

    public static String getCode(){
        Random r = new Random();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            char c = list.get(index);
            sb.append(c);
        }

        int num = r.nextInt(10);
        sb.append(num);

        char[] arr = sb.toString().toCharArray();
        int randomIndex = r.nextInt(arr.length);
        char tmp = arr[randomIndex];
        arr[randomIndex] = arr[arr.length - 1];
        arr[arr.length - 1] = tmp;

        return new String(arr);

    }

}
/*package com.niit.test;

import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        String str = getCode();
        System.out.println(str);
    }

    public static String getCode() {
        Random r = new Random();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            char c = list.get(index);
            sb.append(c);
        }

        int num = r.nextInt(10);
        sb.append(num);

        char[] arr = sb.toString().toCharArray();
        int randomIndex = r.nextInt(arr.length);
        char tmp = arr[randomIndex];
        arr[randomIndex] = arr[arr.length - 1];
        arr[arr.length - 1] = tmp;

        return new String(arr);

    }
}
*/
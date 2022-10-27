package com.bao;


import java.util.Arrays;

public class import01 {
    public static void main(String[] args) {
        int[] arr = {-1, 20, 2, 13, 3};
        //使用系统提供的Arrays排序
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

    }
}

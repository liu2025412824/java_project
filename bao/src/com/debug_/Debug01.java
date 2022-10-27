package com.debug_;

import java.util.Arrays;

public class Debug01 {
    public static void main(String[] args) {

        int[] arr = {1,-1,10,-20,100};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
          System.out.println("111");
    }
}

package arrays_;

import java.util.Arrays;

public class ArraysMethod02 {
    public static void main(String[] args) {
        Integer[] arr = {1,-1,7,0,89};
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(arr2));

        Integer[] num = {9,3,2};
        Arrays.fill(num,99);
        System.out.println(Arrays.toString(num));

        boolean b = Arrays.equals(arr,arr2);
        System.out.println(b);

    }
}

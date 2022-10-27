package arrays_;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class ArraysMethod01 {
    public static void main(String[] args) {
        Integer[] integers = {1,20,50};
        System.out.println(Arrays.toString(integers));

        Integer[] arr = {1,-1,7,0,89};
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer)o1;
                Integer i2 = (Integer)o2;
                return i1 - i2;
            }
        });

        System.out.println("定制的排序："+Arrays.toString(arr));
    }
}

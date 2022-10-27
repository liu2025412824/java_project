package StringBuffer_;

import java.util.Scanner;

public class StringBufferExercise01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入商品名称：");
        String goods = input.next();
        System.out.println("请输入商品价格：");
        String price = input.next();
        StringBuffer sb = new StringBuffer(price);
        for(int i = sb.lastIndexOf(".")-3;i>0;i -= 3){
            sb.insert(i,",");
        }
        System.out.println(goods+" "+sb);
    }
}


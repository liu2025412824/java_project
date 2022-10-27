package exception_;

import java.util.Scanner;

public class TryCatch01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = 0;
        while (true) {
            System.out.println("请输入一个整数：");
            try {
                num = Integer.parseInt(input.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("你输入的不是一个整数");
            }
        }

        System.out.println("你输入的值是："+num);

    }

}


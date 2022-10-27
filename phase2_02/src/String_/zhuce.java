package String_;

import java.util.Scanner;

public class zhuce {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            String name = input.next();
            String pwd = input.next();
            String email = input.next();

            try {
                userRegister(name,pwd,email);
                System.out.println("注册成功!");
                flag = false;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }

    public static void userRegister(String name,String pwd,String email){
        if(!(name != null && pwd != null && email != null)){
            throw new RuntimeException("参数不能为为空");
        }

        if(!(name.length()==2 || name.length() == 3 || name.length()==4)){
            throw new RuntimeException("用户名长度为2或3或4");
        }

        if(!(pwd.length() == 6 && isDigital(pwd))){
            throw new RuntimeException("密码的长度为6并且得为全是数字");
        }

        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if(!(i>0 && j>i)){
            throw new RuntimeException("邮箱中包含@和. 并且@在.前面");
        }
    }

    public static boolean isDigital(String pwd){
        char[] chars = pwd.toCharArray();
        for (int i = 0; i < pwd.length(); i++) {
            if(!Character.isDigit(chars[i])){
                return false;
            }
        }
        return true;
    }
}

package OOP_;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 该类是完成零钱通的各个功能的类
 * 使用OOP(面向对象编程)
 */

public class Sys_OOP {
    //1.定义相关的变量
    boolean loop = true;
    Scanner input = new Scanner(System.in);
    String key ="";

    //2.完成零钱通明细
    String details = "------------------零钱通明细------------------";

    //3.完成收益入账 完成功能驱动程序员增加新的变化和代码
    //定义新的变量
    double money = 0;
    double banlance = 0;
    Date date = null;  //date表示日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//用于日期格式化

    //4.完成消费
    String note=null;

    public void mainMenu(){
        do{

            System.out.println("\n================零钱通菜单OOP版================");
            System.out.println("\t\t\t1.零钱通明细");
            System.out.println("\t\t\t2.收益入账");
            System.out.println("\t\t\t3.消费");
            System.out.println("\t\t\t4.退 出");

            System.out.print("请选择<1-4>：");
            key = input.next();
            switch(key){
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("输入有误，请重新输入:");
                    break;
            }
        }while(loop);
        System.out.println("已退出零钱通程序...");
    }

    public void detail(){
        System.out.println(details);
    }

    public void income(){
        System.out.print("收益入账:");
        money = input.nextDouble();
        //找出不正确的金额条件，然后给出提示，就直接break
        if(money <= 0){
            System.out.println("收益入账金额 需要 大于 0");
            return;
        }

        banlance += money;
        //拼接受益人入账信息到哦details
        date = new Date(); //获取当前日期
        details += "\n收益入账\t+"+money+"\t"+sdf.format(date)+"\t余额："+banlance;
    }

    public void pay(){
        System.out.print("消费金额:");
        money = input.nextDouble();
        if(money <= 0 || money > banlance){
            System.out.println("你的消费金额应该在 0-"+banlance);
            return;
        }

        banlance -= money;
        System.out.print("请输入消费项目：");
        note = input.next();
        date = new Date();
        details += "\n"+note+"\t-"+money+"\t"+sdf.format(date)+"\t余额："+banlance;
    }

    public void exit(){
        String choice = "";
        while(true){
            System.out.print("你确定要退出吗？<y/n> ：");
            choice = input.next();
            if("y".equals(choice)){
                System.out.println("退出成功");
                break;
            }else if("n".equals(choice)){
                System.out.println("已取消退出");
                break;
            }else{
                System.out.println("输入有误，请重新输入");
            }
        }
        //当用户退出while,再进行判断
        if("y".equals(choice)){
            loop = false;
        }
    }
}

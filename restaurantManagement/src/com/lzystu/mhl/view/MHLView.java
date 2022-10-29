package com.lzystu.mhl.view;

import com.lzystu.mhl.domain.DiningTable;
import com.lzystu.mhl.domain.Employee;
import com.lzystu.mhl.service.DiningTableService;
import com.lzystu.mhl.service.EmployeeService;
import com.lzystu.mhl.utils.Utility;

import java.util.List;

/**
 * @author Lzy
 * @version 1.0
 */
public class MHLView {

    private boolean loop = true;//控制是否退出菜单
    private String key = "";//接收用户的选择
    //定义EmployeeService属性
    private EmployeeService employeeService= new EmployeeService();
    //定义DiningTableService属性
    private DiningTableService diningTableService = new DiningTableService();

    public static void main(String[] args){
        new MHLView().mainMenu();
    }

    public void listDiningTable(){
        List<DiningTable> list = diningTableService.list();
        System.out.println("\n餐桌编号\t\t餐桌状态");
        for (DiningTable diningTable:list){
            System.out.println(diningTable);
        }
        System.out.println("================显示完毕================");
    }
    public void mainMenu(){
        while(loop){
            System.out.println("================满汉楼================");
            System.out.println("\t\t1.登录满汉楼");
            System.out.println("\t\t2.退出满汉楼");
            System.out.print("请输入您的选择：");
            key = Utility.readString(1);
            switch(key){
                case "1":
                    System.out.print("请输入员工号：");
                    String empId = Utility.readString(50);
                    System.out.print("请输入密码：");
                    String pwd = Utility.readString(50);
                    Employee employee = employeeService.getEmployeeByIdAndPwd(empId,pwd);
                    //到数据库去判断
                    if(employee != null){ //说明存在该用户
                        System.out.println("==================登陆成功("+employee.getName()+")==================\n");
                        //显示二级菜单
                        while(loop){
                            System.out.println("================满汉楼(二级菜单)================");
                            System.out.println("\t\t1.显示餐桌状态");
                            System.out.println("\t\t2.预定餐桌");
                            System.out.println("\t\t3.显示所有菜品");
                            System.out.println("\t\t4.点餐服务");
                            System.out.println("\t\t5.查看账单");
                            System.out.println("\t\t6.结账");
                            System.out.println("\t\t9.退出满汉楼");
                            System.out.print("请输入你的选择：");
                            key = Utility.readString(1);
                            switch(key){
                                case "1":
                                    //显示餐桌状态
                                    listDiningTable();
                                    break;
                                case "2":
                                    System.out.println("预定餐桌");
                                    break;
                                case "3":
                                    System.out.println("显示所有菜品");
                                    break;
                                case "4":
                                    System.out.println("点餐服务");
                                    break;
                                case "5":
                                    System.out.println("查看账单");
                                    break;
                                case "6":
                                    System.out.println("结账");
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("您的输入有误，请重新输入：");
                            }
                        }
                    }else{
                        System.out.println("==================登陆失败==================");
                    }
                    break;
                case "2":
                    loop = false;
                    break;
                default:
                    System.out.println("您的输入有误，请重新输入：");
            }
        }
        System.out.println("你退出了满汉楼系统~");
    }
}

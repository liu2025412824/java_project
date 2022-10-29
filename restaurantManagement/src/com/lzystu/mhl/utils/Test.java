package com.lzystu.mhl.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Lzy
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) throws SQLException {

        //测试Utility类
        System.out.println("请输入一个整数：");
        int i = 0;
        i = Utility.readInt();
        System.out.println("i="+i);

        //测试一下JDBCUtilsByDruid
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println(connection);
    }
}

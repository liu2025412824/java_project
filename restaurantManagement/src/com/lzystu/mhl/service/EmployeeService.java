package com.lzystu.mhl.service;

import com.lzystu.mhl.dao.EmployeeDAO;
import com.lzystu.mhl.domain.Employee;

/**
 * @author Lzy
 * @version 1.0
 */
public class EmployeeService {

    //定义一个EmployeeDAO属性
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    //根据empId和pwd返回一个Employee对象
    //如果查询不到，就返回null
    public Employee getEmployeeByIdAndPwd(String empId,String pwd){
        Employee employee =
                employeeDAO.querySingle("select * from employee where empId=? and pwd=md5(?)",Employee.class,empId,pwd);
        return employee;
    }
}

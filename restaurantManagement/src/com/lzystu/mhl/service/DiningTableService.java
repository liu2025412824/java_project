package com.lzystu.mhl.service;

import com.lzystu.mhl.dao.DiningTableDAO;
import com.lzystu.mhl.domain.DiningTable;

import java.util.List;

/**
 * @author Lzy
 * @version 1.0
 */
public class DiningTableService {

    //定义一个DiningTableDAO对象
    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    //返回所有餐桌的信息
    public List<DiningTable> list() {
        return diningTableDAO.queryMulti("select id,state from diningTable",DiningTable.class);
    }

    //根据id，查询对应的餐桌DiningTable对象
    //如果返回null,表示id编号对应的餐桌不存在
    public DiningTable getDiningTableById(int id){
        //小技巧：把sql语句放在查询分析器去测试一下.
        return diningTableDAO.querySingle("select * from diningTable where id = ?",DiningTable.class,id);
    }

    //如果餐桌可以预定，调用方法，对其状态进行更新(包括预定人的名字和电话)
    public boolean orderDiningTable(int id,String orderName,String orderTel){
        int update =
                diningTableDAO.update("update diningTable set state='已经预定',orderName=?,orderTel=? where id=?",orderName,orderTel,id);
        return update>0; //(如果update>0则返回真,其他则返回假)
    }
}

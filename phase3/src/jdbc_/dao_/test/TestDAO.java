package jdbc_.dao_.test;

import com.alibaba.druid.support.json.JSONUtils;
import jdbc_.dao_.dao.ActorDAO;
import jdbc_.dao_.domain.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Lzy
 * @version 1.0
 */
public class TestDAO {

    @Test
    public void testActorDAO(){
        ActorDAO actorDAO = new ActorDAO();
        //1.查询
        List<Actor> actors = actorDAO.queryMulti("select * from actor where id >= ?",Actor.class,1);
        for (Actor actor : actors) {
            System.out.print(actor);
        }

        //2.查询单行多列
        System.out.println("\n==========查询单行多列结果==========");
        Actor actor = actorDAO.querySingle("select * from actor where name=?",Actor.class,"刘德华");
        System.out.println(actor);

        //3，查询单行单列
        System.out.println("==============查询单行单列值==============");
        Object o = actorDAO.queryScalar("select name from actor where id = ?",2);
        System.out.println(o);

        //dml操作 insert,update,delete
        System.out.println("===========================================");
        int update = actorDAO.update("insert into actor values(null,?,?,?,?)", "张三", "男", "1996-11-24", "10256");
        System.out.println(update>0 ? "执行成功" : "执行没有影响表");
    }

}

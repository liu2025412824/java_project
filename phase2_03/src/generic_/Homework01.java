package generic_;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Homework01 {
    public static void main(String[] args) {

    }

    @Test
    public void testList(){
        DAO<User> dao = new DAO<>();
        dao.save("001",new User("jack",1,10));
        dao.save("002",new User("king",2,18));
        dao.save("003",new User("smith",1,38));

        List<User> list = dao.list();
        System.out.println(list);

        dao.update("003",new User("milan",3,58));
        dao.delete("001");
        list=dao.list();
        System.out.println(list);

        System.out.println("id003="+dao.get("003"));
    }
}

class DAO<T>{
    Map<String,T> map = new HashMap<>();

    public void save(String id,T entity){
        map.put(id, entity);
    }
    public T get(String id){
        return map.get(id);
    }

    public void update(String id,T entity){
        map.put(id,entity);
    }

    public List<T> list(){
        //方法一
        List<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        list.addAll(values);
        return list;

        //方法二
//        List<T> list2 = new ArrayList<>();
//        Set<String> keys = map.keySet();
//        for(String key:keys){
//            list2.add(get(key));
//        }
//        return list2;
    }

    public void delete(String id){
        map.remove(id);
    }
}

class User{
    private String name;
    private int id;
    private int age;

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}

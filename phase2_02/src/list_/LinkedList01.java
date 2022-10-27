package list_;

public class LinkedList01 {
    public static void main(String[] args) {
        //模拟一个简单的双向链表
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node lzy = new Node("lzy");

        //连接三个结点，形成双向链表
        jack.next = tom;
        tom.next = lzy;

        lzy.prev = tom;
        tom.prev = jack;

        Node first = jack;
        Node last = lzy;
        //演示从头到尾进行遍历
        while(true){
            if(first == null){
                break;
            }
            System.out.println(first);
            first = first.next;
        }
        //演示，从尾到头进行遍历
        while (true){
            if(last == null){
                break;
            }
            System.out.println(last);
            last = last.prev;
        }

        //创建一个新结点，name是smith,插入到tom的后面
        Node smith = new Node("smith");
        tom.next = smith;
        smith.next = lzy;
        smith.prev = tom;
        lzy.prev = smith;

        first = jack;
        last = smith;

        while (true){
            if(first == null){
                break;
            }
            System.out.println(first);
            first = first.next;
        }


    }
}

//定义一个Node类，Node对象表示双向链表的一个结点
class Node{
    public Object item;
    public Node next;
    public Node prev;
    public Node(Object name){
        this.item = name;
    }

    @Override
    public String toString() {
        return "Node name="+item;
    }
}
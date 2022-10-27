package set_;

public class HashSetStructure {
    public static void main(String[] args) {
        Node[] table = new Node[16];

        Node john = new Node("john",null);
        table[2] = john;
        Node james = new Node("james", null);
        john.next = james;
        Node rose = new Node("rose",null);
        james.next = rose;

        System.out.println(table[2]);

    }
}

class Node{
    Object item;//存放数据
    Node next;//指向下一个结点

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }
}

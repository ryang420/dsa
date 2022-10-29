package list;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表测试");
        DoubleNode node1 = new DoubleNode(1, "宋江", "及时雨");
        DoubleNode node2 = new DoubleNode(2, "卢俊义", "玉麒麟");
        DoubleNode node3 = new DoubleNode(3, "吴用", "智多星");
        DoubleNode node4 = new DoubleNode(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node4);
        doubleLinkedList.list();

        // 修改
        DoubleNode newNode = new DoubleNode(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newNode);
        System.out.println("双向链表节点4修改后：");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.delete(3);
        System.out.println("删除节点3后：");
        doubleLinkedList.list();

        // 按照编号添加节点
        DoubleNode node0 = new DoubleNode(0, "Temp", "好汉");
        doubleLinkedList.addNodeByNo(node3);
        doubleLinkedList.addNodeByNo(node0);
        System.out.println("添加节点编号为0和3后：");
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    // 创建一个头结点
    private final DoubleNode head = new DoubleNode(0, null, null);

    public DoubleNode getHead() {
        return head;
    }

    // 添加节点到双向向链表的尾部
    public void add(DoubleNode doubleNode) {
        DoubleNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = doubleNode;
        doubleNode.prev = temp;
    }

    // 按照编号顺序添加节点
    public void addNodeByNo(DoubleNode doubleNode) {
        int no = doubleNode.no;
        DoubleNode temp = head.next;
        if (temp == null) temp = doubleNode;

        while (temp != null) {
            if (temp.no == no) {
                System.out.println("已存在结点编号为" + no +"的节点");
                break;
            }

            if (temp.no > no) {
                temp.prev.next = doubleNode;
                doubleNode.prev = temp.prev;
                doubleNode.next = temp;

                break;
            }
            temp = temp.next;
        }
    }

    // 显示链表(遍历)
    public void list() {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        DoubleNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 修改链表的节点，根据no编号来修改，即no不能变
    public void update(DoubleNode doubleNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        DoubleNode temp = head.next;
        while (temp != null) {
            if (temp.no == doubleNode.no) {
                temp.name = doubleNode.name;
                temp.nickName = doubleNode.nickName;
                break;
            }
            temp = temp.next;
        }
    }

    // 按照编号删除节点
    public void delete(int no) {
        DoubleNode temp = head.next;
        while (temp != null) {
            if (temp.no == no) {
                temp.prev.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                break;
            }
            temp = temp.next;
        }
    }
}

class DoubleNode {
    public int no; // hero编号
    public String name;
    public String nickName;
    public DoubleNode next; //指向下一个节点
    public DoubleNode prev; //指向上一个节点

    public DoubleNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
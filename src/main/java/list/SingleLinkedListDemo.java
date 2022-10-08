package list;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "武松", "行者");
        HeroNode hero6 = new HeroNode(6, "鲁智深", "花和尚");
        HeroNode hero7 = new HeroNode(7, "李逵", "黑旋风");

        // 创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 添加节点到链表尾部
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);

        //按照编号顺序添加节点
//        singleLinkedList.addNodeByNo(hero1);
//        singleLinkedList.addNodeByNo(hero4);
//        singleLinkedList.addNodeByNo(hero2);
//        singleLinkedList.addNodeByNo(hero3);
//        singleLinkedList.list();

//        //测试修改节点的代码
//        HeroNode newNode = new HeroNode(2, "小卢", "麒麟~");
//        singleLinkedList.update(newNode);
//        System.out.println("修改节点2后：");
//        singleLinkedList.list();
//
//        //测试删除节点代码
//        System.out.println("删除节点后：");
//        singleLinkedList.delete(3);
//        singleLinkedList.list();
//
//        // 链表节点个数
//        System.out.println("链表节点个数: ");
//        System.out.println(getLength(singleLinkedList.getHead()));
//
//        // 返回链表中倒数第2个节点
//        System.out.println(getKthNode(singleLinkedList.getHead(), 3));

        // 反转链表
//        System.out.println("反转链表：");
//        reverseList(singleLinkedList.getHead());
//        singleLinkedList.list();

        // 从后往前打印链表节点
//        System.out.println("从后往前打印链表节点:");
//        printListReversely(singleLinkedList.getHead());

        // 合并2个有序链表
        SingleLinkedList list1 = new SingleLinkedList();
        list1.add(hero1);
        list1.add(hero3);
        list1.add(hero4);
        list1.add(hero7);
        System.out.println("list1: ");
        list1.list();

        SingleLinkedList list2 = new SingleLinkedList();
        list2.add(hero2);
        list2.add(hero5);
        list2.add(hero6);
        System.out.println("list2: ");
        list2.list();

        SingleLinkedList mergedList = mergeList(list1, list2);
        System.out.println("合并list1和list2后：");
        mergedList.list();
    }

    // 1. 获取单链表的节点个数。如果链表有头节点，则头节点不计算

    /**
     * @param head 链表的头结点
     * @return 返回节点的有效个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    // 2. 查找单链表中倒数第k个节点
    public static HeroNode getKthNode(HeroNode head, int k) {
        // 获取链表中节点的个数
        int size = getLength(head);
        int n = size - k;
        if (n < 0 || k <= 0) return null;

        HeroNode temp = head.next;
        while (n > 0) {
            temp = temp.next;
            n--;
        }
        return temp;
    }

    // 3. 单链表反转，利用头插法。创建一个新的head，然后遍历链表的节点，插入到这新的head的下一个节点前面。

    /**
     *
     */
    public static void reverseList(HeroNode head) {
        // 链表为空或者只有一个节点，则直接返回，不用反转。
        if (head.next == null || head.next.next == null) {
            return;
        }

        HeroNode current = head.next;
        HeroNode next = null;
        // 定义一个临时的头节点
        HeroNode reverseHead = new HeroNode(0, null, null);
        while (current != null) {
            next = current.next; // 暂时保存当前节点的下一个节点
            current.next = reverseHead.next; //将当前节点的下一个节点指向新的链表的最前端
            reverseHead.next = current; // 将current节点连接到新的head上
            current = next; // current指针后移
        }
        head.next = reverseHead.next;
    }

    // 4. 从后往前打印链表的节点，利用Stack来实现。
    public static void printListReversely(HeroNode head) {
        if (head.next == null) {
            return;
        }

        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        while (temp != null) {
            stack.add(temp);
            temp = temp.next;
        }

        // 打印链表节点
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    // 5. 合并两个有序链表，例如：1->3->5, 2->4->7 = 1->2->3->4->5->7
    public static SingleLinkedList mergeList(SingleLinkedList list1, SingleLinkedList list2) {
        // 新建一个list，用于保存合并后的list节点
        SingleLinkedList mergedList = new SingleLinkedList();

        HeroNode temp1 = list1.getHead().next;
        HeroNode temp2 = list2.getHead().next;

        while (temp1 != null && temp2 != null) {
            int n1 = temp1.no;
            int n2 = temp2.no;
            if (n1 < n2) {
                mergedList.add(new HeroNode(temp1.no, temp1.name, temp1.nickName));
                temp1 = temp1.next;
            } else {
                mergedList.add(new HeroNode(temp2.no, temp2.name, temp2.nickName));
                temp2 = temp2.next;
            }
        }

        if (temp1 == null && temp2 != null) {
            mergedList.add(temp2);
        }

        if (temp1 != null) {
            mergedList.add(temp1);
        }

        return mergedList;
    }
}

// 管理节点类
class SingleLinkedList {
    // 创建一个头结点
    private final HeroNode head = new HeroNode(0, null, null);

    public HeroNode getHead() {
        return head;
    }

    // 添加节点到单向链表的尾部
    public void add(HeroNode heroNode) {
        HeroNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    // 按照编号将英雄添加到链表中
    public void addNodeByNo(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false; // 判断添加的节点编号是否已在链表存在

        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            } else {
                temp = temp.next;
            }
        }

        if (flag) {
            System.out.printf("添加的英雄编号%d已存在，不能再添加。\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 显示链表(遍历)
    public void list() {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 修改链表的节点，根据no编号来修改，即no不能变
    public void update(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            if (temp.no == heroNode.no) {
                temp.name = heroNode.name;
                temp.nickName = heroNode.nickName;
                break;
            }
            temp = temp.next;
        }
    }

    // 按照编号删除节点
    public void delete(int no) {
        HeroNode temp = head;
        while (temp != null) {
            if (temp.next != null && temp.next.no == no) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
}

/*
 * 每个HeroNode对象代表一个节点
 */
class HeroNode {
    public int no; // hero编号
    public String name;
    public String nickName;
    public HeroNode next; //指向下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
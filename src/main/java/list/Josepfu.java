package list;

/**
 * 约瑟夫环
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        System.out.println("测试小孩出圈：");
        circleSingleLinkedList.countBoy(1, 2, 5); // 2->4->1->5->3
    }
}

// 环形单向链表
class CircleSingleLinkedList {
    // 创建一个first节点，指向环形链表的第一个结点
    private Boy first = null;

    // 添加小孩节点，构成一个环状
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums 不能小于1");
            return;
        }
        Boy curBoy = null; // 创建一个辅助指针
        // 创建环形链表，它有nums个节点
        // first指针不移动，指向第一个节点，curBoy指向最新添加的一个节点
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历当前环形链表
     */
    public void showBoy() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }

        Boy curBoy = first; // 创建一个辅助指针
        while (true) {
            System.out.printf("小孩编号 %d\n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    // 根据用户输入，计算小孩出圈的顺序
    public void countBoy(int startNo, int countNum, int nums) {
        // 数据校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误");
            return;
        }
        // 创建辅助指针helper，初始化指向first，然后让其指向first的前一个节点
        Boy helper = first;
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }
        // 移动first并指向startNo，helper也同步移动
        for (int i = 0; i < startNo - 1; i++ ) {
            first = first.getNext();
            helper = helper.getNext();
        }

        // 第countNum小孩出圈
        while (first != helper) {
            for (int k = 0; k < countNum - 1; k++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("第%d个小孩出圈\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最以后一个小孩%d出圈\n", first.getNo());
    }
}

// 创建Boy类，表示一个节点
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
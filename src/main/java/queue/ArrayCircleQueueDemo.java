package queue;

import java.util.Scanner;

public class ArrayCircleQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(3);

        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("e(exit): 退出队列");
            System.out.println("g(get): 从队列头取出数据");
            System.out.println("h(head): 显示队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数字：");
                    try {
                        queue.addQueue(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        System.out.println(queue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'h':
                    try {
                        System.out.println(queue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
        System.out.println("程序退出！");
    }
}

class CircleArrayQueue {
    private final int maxSize; //表示数组的最大容量
    private int front = 0; // front指向队列的第一个元素
    private int rear = 0; // rear指向队列最后一个元素的后一个位置，即队列保留一个空位作为标识
    private final int[] arr; //存放队列数据

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize + 1;
        arr = new int[maxSize + 1]; // 增加一个空位，作为rear的指向
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满！");
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //求当前队列的有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列是空的");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //显示队列头元素
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的，没有数据显示！");
        }
        return arr[front];
    }
}
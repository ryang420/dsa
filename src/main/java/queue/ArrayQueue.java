package queue;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQueue {
    private int front, rear, queueSize;
    private int[] arr;

    public ArrayQueue(int size) {
        front = rear = -1;
        arr = new int[size];
        queueSize = size;
    }

    public void add(int n) {
        if (isFull()) {
            throw new RuntimeException("Queue is full!");
        }
        rear++;
        arr[rear] = n;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        front++;
        return arr[front];
    }

    private boolean isFull() {
        return rear == queueSize;
    }

    //判断队列是否是空
    private boolean isEmpty() {
        return front == rear;
    }

    //展示队列的第一个元素
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        return arr[front + 1];
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        ArrayQueue que = new ArrayQueue(3);

        char key = ' ';
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
                    System.out.println(que);
                    break;
                case 'a':
                    System.out.println("输入一个数字：");
                    try {
                        que.add(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        System.out.println(que.pop());
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
                        System.out.println(que.peek());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
            System.out.println("程序退出！");
        }
    }
}

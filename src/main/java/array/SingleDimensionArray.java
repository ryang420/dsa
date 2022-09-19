package array;

public class SingleDimensionArray {
    int arr[] = null;

    public SingleDimensionArray(int sizeOfArray) {
        arr = new int[sizeOfArray];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
    }

    public void insert(int location, int value) {
        try {
            if (arr[location] == Integer.MIN_VALUE) {
                arr[location] = value;
                System.out.println("Successfully inserted!");
            } else {
                System.out.println("This cell is already occupied!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array!");
        }
    }

    public static void main(String[] args) {
        SingleDimensionArray array = new SingleDimensionArray(10);
        array.insert(0, 1);
        array.insert(1, 2);
        array.insert(2, 3);
        array.insert(1 ,10);
        array.insert(12, 20);

    }
}

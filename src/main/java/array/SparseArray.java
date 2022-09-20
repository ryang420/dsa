package array;

import java.io.*;
import java.util.Arrays;

public class SparseArray {
    public static int[][] toSparseArray(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int nums = 0;

        for (int[] rows : arr) {
            for (int ele : rows) {
                if (ele != 0) {
                    nums++;
                }
            }
        }

        int[][] sparseArray = new int[nums + 1][3];
        sparseArray[0][0] = row;
        sparseArray[0][1] = col;
        sparseArray[0][2] = nums;

        int ind = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] != 0) {
                    ind++;
                    sparseArray[ind][0] = i;
                    sparseArray[ind][1] = j;
                    sparseArray[ind][2] = arr[i][j];
                }
            }
        }

        return sparseArray;
    }

    public static int[][] toArray(int[][] sparseArray) {
        int row = sparseArray[0][0];
        int col = sparseArray[0][1];

        int[][] originalArray = new int[row][col];
        for (int i = 1; i < sparseArray.length; i++) {
            originalArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        return originalArray;
    }

    public static void savetoFile(int[][] array, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));) {

            for (int[] row : array) {
                for (int i = 0; i < row.length; i++) {
                    writer.write(String.valueOf(row[i]));
                    if (i != row.length - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        for (int[] r : arr) {
            System.out.println(Arrays.toString(r));
        }

        System.out.println("\nSparse Array: ");
        int[][] sparseArray = toSparseArray(arr);
        for (int[] row : sparseArray) {
            System.out.println(Arrays.toString(row));
        }
        savetoFile(sparseArray, "sparseArray.txt");

        System.out.println("\nOriginal Array: ");
        int[][] originalArray = toArray(sparseArray);
        for (int[] row : originalArray) {
            System.out.println(Arrays.toString(row));
        }
    }
}

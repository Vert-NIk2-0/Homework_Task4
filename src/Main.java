import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        int[][] matrix = new int[10][10];
        Random rand = new Random();

//      Массив ====================================
        System.out.println("Unsorted array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(21);
            System.out.print(array[i] + " ");
        }

        step1(array);
        System.out.println("\n\nSorted array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

//      Матрица ===================================
        System.out.println("\n\nUnsorted matrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = rand.nextInt(21);
                if(matrix[i][j] < 10) {
                    System.out.print(matrix[i][j] + "  ");
                } else System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        step2(matrix);
        System.out.println("\nSorted matrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] < 10) {
                    System.out.print(matrix[i][j] + "  ");
                } else System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[] step1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {

                    // Меняем местами числа
                    array[i] ^= array[j];
                    array[j] ^= array[i];
                    array[i] ^= array[j];

                }
            }
        }

        return array;
    }
    static int[][] step2(int[][] array) {

        int count = 1;
        for (int i = 0; i < array.length * array[0].length - 1; i++) {
            for (int j = 0; j < array.length * array[0].length - count; j++) {
                if (array[j / array.length][j % array.length] > array[(j + 1) / array.length][(j + 1) % array.length]) {

                    array[j / array.length][j % array.length] ^= array[(j + 1) / array.length][(j + 1) % array.length];
                    array[(j + 1) / array.length][(j + 1) % array.length] ^= array[j / array.length][j % array.length];
                    array[j / array.length][j % array.length] ^= array[(j + 1) / array.length][(j + 1) % array.length];
                }
            }
            count++;
        }
        return array;
    }

}
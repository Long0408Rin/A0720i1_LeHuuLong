package B14_SortAlgorithm;


import java.util.Arrays;

public class Insert_Sort {

        public static void sort(int[] array) {
            for (int i = 1; i < array.length; i++) {
                int currentElement = array[i];
                int k = i - 1;
                for (; k >= 0 && array[k] > currentElement; k--) {
                    System.out.println(array[k + 1]);
                    System.out.println(array[k]);
                    array[k + 1] = array[k];
                }
                array[k + 1] = currentElement;
            }

        }

        public static void main(String[] args) {
            int[] myArray = {1, 10, 5, 8, 3};
            sort(myArray);
            System.out.println(Arrays.toString(myArray));
        }
    }


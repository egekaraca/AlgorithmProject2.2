import java.util.Random;

public class SortingAlgorithmTester {


    public static class randomArrayGenerator {
        //--------------------------------------------------------
        // Summary: Generates a random array of integers with the specified size.
        // Precondition: The size is a positive integer representing the array's length.
        // Postcondition: Returns an array filled with random integer values.
        //--------------------------------------------------------
        public static int[] randomArray(int size) {
            int[] rndArray = new int[size];
            Random rnd = new Random();
            for (int i = 0; i < size; i++) {
                rndArray[i] = rnd.nextInt();
            }
            return rndArray;
        }
    }


    public static class ascendingArrayGenerator {
        //--------------------------------------------------------
        // Summary: Generates an array of integers in ascending order starting from 0.
        // Precondition: The size is a positive integer representing the array's length.
        // Postcondition: Returns an array where each element is an integer in ascending order, starting from 0.
        //--------------------------------------------------------
        public static int[] ascendingArray(int size) {
            int[] ascArray = new int[size];
            for (int i = 0; i < size; i++) {
                ascArray[i] = i;
            }
            return ascArray;
        }
    }


    public static class descendingArrayGenerator {
        //--------------------------------------------------------
        // Summary: Generates an array of integers in descending order starting from the specified size.
        // Precondition: The size is a positive integer representing the array's length.
        // Postcondition: Returns an array where each element is an integer in descending order.
        //--------------------------------------------------------
        public static int[] descendingArray(int size) {
            int[] descArray = new int[size];
            for (int i = 0; i < size; i++) {
                descArray[i] = size - i;
            }
            return descArray;
        }
    }


    public static long performanceTest(int[] array, long studentId, int algo) {
        //--------------------------------------------------------
        // Summary: Measures the time taken by a sorting algorithm to sort an array.
        // Precondition: The array is an unsorted integer array, studentId is a long number,
        // and algo is an integer representing the algorithm to test.
        // Postcondition: Returns the time taken (in milliseconds) for the sorting algorithm to sort the array.
        //--------------------------------------------------------
        long startTime = System.currentTimeMillis();
        switch (algo) {
            case 1:
                SortingAlgorithms.sort1(array, studentId);
                break;
            case 2:
                SortingAlgorithms.sort2(array, studentId);
                break;
            case 3:
                SortingAlgorithms.sort3(array, studentId);
                break;
            case 4:
                SortingAlgorithms.sort4(array, studentId);
                break;
            case 5:
                SortingAlgorithms.sort5(array, studentId);
                break;
        }
        return System.currentTimeMillis() - startTime;
    }


    public static void main(String[] args) {
        //--------------------------------------------------------
        // Summary: The main function runs the sorting algorithms on arrays of different sizes and types,
        // and prints the time taken for each sorting operation.
        // Precondition: It requires a student ID, test sizes, and different sorting algorithms to run.
        // Postcondition: Outputs the sorting times and performance results for different array sizes.
        //--------------------------------------------------------
        long studentId = 2846583495L;
        int testSize = 3;
        int[] sizes = {10000, 20000, 40000, 80000, 100000};
        int totalSize = testSize * sizes.length * 3;


        long[] sort1Times = new long[totalSize];
        long[] sort2Times = new long[totalSize];
        long[] sort3Times = new long[totalSize];
        long[] sort4Times = new long[totalSize];
        long[] sort5Times = new long[totalSize];

        for (int t = 0; t < testSize; t++) {
            System.out.println("Running test #" + (t + 1));

            for (int i = 0; i < sizes.length; i++) {
                int randomNum = sizes[i];
                System.out.println("Running process for array size: " + randomNum);


                int[] ascendingArr = ascendingArrayGenerator.ascendingArray(randomNum);
                int[] randomArr = randomArrayGenerator.randomArray(randomNum);
                int[] descendingArr = descendingArrayGenerator.descendingArray(randomNum);


                int baseIndex = (t * sizes.length * 3) + (i * 3);


                sort1Times[baseIndex] = performanceTest(ascendingArr.clone(), studentId, 1);
                sort1Times[baseIndex + 1] = performanceTest(descendingArr.clone(), studentId, 1);
                sort1Times[baseIndex + 2] = performanceTest(randomArr.clone(), studentId, 1);  

                System.out.println("Sort 1 done for array size: " + randomNum);

                sort2Times[baseIndex] = performanceTest(ascendingArr.clone(), studentId, 2);
                sort2Times[baseIndex + 1] = performanceTest(descendingArr.clone(), studentId, 2);
                sort2Times[baseIndex + 2] = performanceTest(randomArr.clone(), studentId, 2);

                System.out.println("Sort 2 done for array size: " + randomNum);

                sort3Times[baseIndex] = performanceTest(ascendingArr.clone(), studentId, 3);
                sort3Times[baseIndex + 1] = performanceTest(descendingArr.clone(), studentId, 3);
                sort3Times[baseIndex + 2] = performanceTest(randomArr.clone(), studentId, 3);

                System.out.println("Sort 3 done for array size: " + randomNum);

                sort4Times[baseIndex] = performanceTest(ascendingArr.clone(), studentId, 4);
                sort4Times[baseIndex + 1] = performanceTest(descendingArr.clone(), studentId, 4);
                sort4Times[baseIndex + 2] = performanceTest(randomArr.clone(), studentId, 4);

                System.out.println("Sort 4 done for array size: " + randomNum);

                sort5Times[baseIndex] = performanceTest(ascendingArr.clone(), studentId, 5);
                sort5Times[baseIndex + 1] = performanceTest(descendingArr.clone(), studentId, 5);
                sort5Times[baseIndex + 2] = performanceTest(randomArr.clone(), studentId, 5);

                System.out.println("All sorts done for array size: " + randomNum);
            }
            System.out.println("Test #" + (t + 1) + " completed.");
        }

        System.out.println("\nFinal Results:");
        for (int i = 0; i < testSize; i++) {
            System.out.println("# " + (i + 1) + ":");
            for (int j = 0; j < sizes.length; j++) {
                int baseIndex = (i * sizes.length * 3) + (j * 3);
                System.out.println("  Size " + sizes[j]);
                System.out.println("    Sort 1: Ascending=" + sort1Times[baseIndex] + " ms, Descending=" + sort1Times[baseIndex + 1] + " ms, Random=" + sort1Times[baseIndex + 2] + " ms");
                System.out.println("    Sort 2: Ascending=" + sort2Times[baseIndex] + " ms, Descending=" + sort2Times[baseIndex + 1] + " ms, Random=" + sort2Times[baseIndex + 2] + " ms");
                System.out.println("    Sort 3: Ascending=" + sort3Times[baseIndex] + " ms, Descending=" + sort3Times[baseIndex + 1] + " ms, Random=" + sort3Times[baseIndex + 2] + " ms");
                System.out.println("    Sort 4: Ascending=" + sort4Times[baseIndex] + " ms, Descending=" + sort4Times[baseIndex + 1] + " ms, Random=" + sort4Times[baseIndex + 2] + " ms");
                System.out.println("    Sort 5: Ascending=" + sort5Times[baseIndex] + " ms, Descending=" + sort5Times[baseIndex + 1] + " ms, Random=" + sort5Times[baseIndex + 2] + " ms");
            }
        }
    }
}










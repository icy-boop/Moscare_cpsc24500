package a4;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.stream.Stream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Assignment4 {

	/**
	 * @param filename
	 * @return number of lines in a text file
	 * @throws IOException
	 */
    public static int getNoLines(String fileName) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
	/**
	 * 
	 * @param filename source file
	 * @return two dim array (jagged array), where each row in the array contains the values in one line of the file,
	 * the length of each row depends on the number of values in each line of the file.
	 * @throws Exception
	 */
    public static int[][] create2DArray(String fileName) {
        int[][] result = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int rows = getNoLines(fileName);
            result = new int[rows][];
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.trim().split("\\s+");
                int[] rowArray = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    rowArray[i] = Integer.parseInt(values[i]);
                }
                result[row++] = rowArray;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int findLongestRow(int[][] array) {
        int maxLength = 0;
        int longestRowIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length > maxLength) {
                maxLength = array[i].length;
                longestRowIndex = i;
            }
        }
        return longestRowIndex;
    }

    public static int findMaxInRow(int[][] array, int rowIndex) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array[rowIndex].length; i++) {
            if (array[rowIndex][i] > max) {
                max = array[rowIndex][i];
            }
        }
        return max;
    }

    public static int findMax(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String fileName = "/Users/clowiemoscare/Documents/sam/Rectangle.java/src/assignment4Data.txt"; // Provide full path if the file is not in the same directory
        int[][] array = create2DArray(fileName);
        int longestRowIndex = findLongestRow(array);
        System.out.println("Number of lines in the file = " + getNoLines(fileName));
        System.out.println("Longest row in the file is: " + longestRowIndex + ", with length of: " + array[longestRowIndex].length);        
        System.out.println("Max value in first row= " + findMaxInRow(array, 0));
        System.out.println("Max value in the array = " + findMax(array));
    }
}

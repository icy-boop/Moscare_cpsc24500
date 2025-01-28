import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HomeworkTest2 {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Lena");
        names.add("Nicholas");
        names.add("Aruna");
        names.add("Anthony");
        names.add("Daniel");
        names.add("Thomas");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name to search for: ");
        String searchName = scanner.nextLine();

        if (names.contains(searchName)) {
            System.out.println("The name " + searchName + " is located in the list.");
        } else {
            System.out.println("There is no such name: " + searchName);
        }

        System.out.print("\nEnter a value for n (n >= 2): ");
        int n = scanner.nextInt();

        if (n < 2) {
            System.out.println("n must be greater than or equal to 2.");
            scanner.close();
            return;
        }

        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        int repeatedNumber = random.nextInt(n - 1) + 1; 

        for (int i = 1; i < n; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < n; i++) {
            int randIndex = random.nextInt(numbers.size());
            int numToAdd = numbers.get(randIndex);
            numbers.add(numToAdd);
            if (numToAdd == repeatedNumber) {
                break;
            }
        }

        int foundRepeatedNumber = findRepeatedNumber(numbers);

        System.out.println("The repeated number is: " + foundRepeatedNumber);

        scanner.close();
    }

    private static int findRepeatedNumber(List<Integer> numbers) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        for (int num : numbers) {
            if (seenNumbers.contains(num)) {
                return num;
            }
            seenNumbers.add(num);
        }
        return -1;
    }
}

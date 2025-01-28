import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeworkTest1 {

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
            System.out.println("The name " + searchName + " is in the list.");
        } else {
            System.out.println("There is no " + searchName + " in the list");
        }

        scanner.close();
    }
}

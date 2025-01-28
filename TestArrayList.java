import java.util.Scanner;

public class TestArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<String> names = new ArrayList<>(10);
        names.add(0, "Lena");
        names.add(1, "Nicholas");
        names.add(2, "Aruna");
        names.add(3, "Anthony");
        names.add(4, "Daniel");
        names.add(5, "Thomas");
    
        System.out.println("Initial ArrayList: " + names);
        names.remove(3); 
        System.out.println("ArrayList after removing an element: " + names);
        names.trimToExactSize();
        System.out.println("ArrayList after trimming to exact size: " + names);
        System.out.println("Current size of the ArrayList: " + names.size());
        System.out.println("You can add more names (type 'exit' to finish):");
        while (true) {
            System.out.print("Enter a name: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                names.add(names.size(), input);
                System.out.println("Updated ArrayList: " + names);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: Cannot add more names. The list is full.");
            }
        }
        scanner.close();
    }
}

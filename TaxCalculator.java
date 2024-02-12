import java.util.Scanner;

public class TaxCalculator {

    public static double calcTax(double income) {
        double tax =0;
        income = income - 4000; //<4000 is 0 tax

        if (income > 0) {
            // Next J$1500 is taxed at 10%
            double nextTaxableAmount = Math.min(income, 1500);
            tax += nextTaxableAmount * 0.10;
            income -= nextTaxableAmount;
        }

        if (income > 0) {
            // Next J$28000 is taxed at 20%
            double nextTaxableAmount = Math.min(income, 28000);
            tax += nextTaxableAmount * 0.20;
            income -= nextTaxableAmount;
        }

        if (income > 0) {
            // Any further amount is taxed at 40%
            tax += income * 0.40;
        }

        return tax;
    }
    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = input.next();
        System.out.print("Enter employee salary: $J");
        double income = input.nextDouble();

        if (income < 0) {
            System.out.println("Invalid input!");
            return;
        }

        double tax = calcTax(income);
        //print
        System.out.println("---Output---");
        System.out.println("Name: " + name);
        System.out.println("Income: $J" + income);
        System.out.println("Income Tax: $J" + tax);
    }
   
}


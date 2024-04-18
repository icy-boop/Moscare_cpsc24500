import java.util.Scanner;

class Complex implements Comparable<Complex> {
    private double real;
    private double imaginary;

    public Complex() {
        this(0, 0);
    }

    public Complex(double real) {
        this(real, 0);
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(Complex complex) {
        this.real = complex.real;
        this.imaginary = complex.imaginary;
    }

    public double getRealPart() {
        return real;
    }

    public double getImaginaryPart() {
        return imaginary;
    }

    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }

    public Complex multiply(Complex other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.imaginary * other.real + this.real * other.imaginary;
        return new Complex(newReal, newImaginary);
    }

    public Complex divide(Complex other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new Complex(newReal, newImaginary);
    }

    public double abs() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    @Override
    public int compareTo(Complex other) {
        return Double.compare(this.abs(), other.abs());
    }

    @Override
    public String toString() {
        if (imaginary == 0) {
            return String.valueOf(real);
        } else if (real == 0) {
            return imaginary + "i";
        } else if (imaginary < 0) {
            return real + " - " + (-imaginary) + "i";
        } else {
            return real + " + " + imaginary + "i";
        }
    }
}

public class ComplexTest {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);

        System.out.print("Enter the first complex number: ");
        double real1 = input.nextDouble();
        double imaginary1 = input.nextDouble();
        Complex complex1 = new Complex(real1, imaginary1);

        System.out.print("Enter the second complex number: ");
        double real2 = input.nextDouble();
        double imaginary2 = input.nextDouble();
        Complex complex2 = new Complex(real2, imaginary2);

        System.out.println(complex1 + " + " + complex2 + " = " + complex1.add(complex2));
        System.out.println(complex1 + " - " + complex2 + " = " + complex1.subtract(complex2));
        System.out.println(complex1 + " * " + complex2 + " = " + complex1.multiply(complex2));
        System.out.println(complex1 + " / " + complex2 + " = " + complex1.divide(complex2));
        System.out.println("|" + complex1 + "| = " + complex1.abs());
    }
}

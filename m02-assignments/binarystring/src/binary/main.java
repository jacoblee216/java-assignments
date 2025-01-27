package binary;
import java.util.Scanner;

public class main {
        public static void main(String[] args) {
        System.out.println("Give me a binary string:");
        Scanner input = new Scanner(System.in);
        String binary = input.nextLine();
        try {
            binaryFormat.validateBinary(binary); // try block to test binary string using custom exception object
            System.out.println("Valid binary number: " + binary);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // catch block to print the thrown exception message
        }
    }
}

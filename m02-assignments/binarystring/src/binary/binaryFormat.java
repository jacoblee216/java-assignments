package binary;
public class binaryFormat {
    public static void validateBinary(String binary) {
        for (int i = 0; i < binary.length(); i++) { // enumerate over the whole string 
            if (binary.charAt(i) != '0' && binary.charAt(i) != '1') { // checks for any other character other than 0 and 1
                throw new IllegalArgumentException("Invalid binary number: " + binary); // if the string has a character other than 0 and 1 it throws an exception
            }
        }
    }
}

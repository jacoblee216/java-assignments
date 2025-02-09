import java.util.*;
import java.io.*;
public class keywordFinder {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Java source file: ");
        String filename = input.nextLine();
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("The number of keywords in " + filename + " is " + countKeywords(file));
        }
        else {
            System.out.println("File " + filename + " does not exist");
        }
        input.close();
    }
    public static int countKeywords(File file) throws Exception {
        String[] keywordString = {
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", 
            "class", "const", "continue", "default", "do", "double", "else", "enum", 
            "extends", "final", "finally", "float", "for", "goto", "if", "implements", 
            "import", "instanceof", "int", "interface", "long", "native", "new", 
            "package", "private", "protected", "public", "return", "short", "static", 
            "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", 
            "transient", "try", "void", "volatile", "while", "true", "false", "null"};
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String word = input.next();
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == '/' && word.charAt(i + 1) == '/') {
                    break;
                }
            }
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == '"') {
                    break;
                }
            }
            for (String keyword : keywordSet) {
                if (word.equals(keyword)) {
                    count++;
                    break;
                }
            }
        }
        input.close();
        return count;
    }
}

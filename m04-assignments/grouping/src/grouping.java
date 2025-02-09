
import java.util.Scanner;
import java.util.Stack;

public class grouping {
        public static boolean isBalanced(String filename) {
            Stack<Character> stack = new Stack<>();
            Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    for (char ch : line.toCharArray()) {
                        if (ch == '(' || ch == '{' || ch == '[') {
                            stack.push(ch);
                        } 
                        else if (ch == ')' || ch == '}' || ch == ']') {
                            if (stack.isEmpty()) {
                                scanner.close();
                                return false; 
                            }
                            char top = stack.pop();
                            if (!isMatchingPair(top, ch)) {
                                scanner.close();
                                return false;
                            }
                        }
                    }
                }
                scanner.close();
            return stack.isEmpty();
        }
    
        public static boolean isMatchingPair(char open, char close) {
            return (open == '(' && close == ')') ||
                   (open == '{' && close == '}') ||
                   (open == '[' && close == ']');
        }
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String filename = scanner.nextLine();
            if (isBalanced(filename)) {
                System.out.println("Correct grouping pairs");
            } else {
                System.out.println("Incorrect grouping pairs");
            }
            scanner.close();
        }
    }



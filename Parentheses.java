import java.util.Scanner;
import java.util.Stack;

public class Parentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        Parentheses(s);
    }

    private static void Parentheses(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                stack.pop();
            }

            if (stack.isEmpty()) {
                // Outermost parentheses found
                result.append(s, start + 1, i); // Exclude outer parentheses
                start = i + 1;
            }
        }

        System.out.println(result.toString());
    }
}

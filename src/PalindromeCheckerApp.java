import java.util.*;

public class UseCase12PalindromeCheckerApp {

    // Strategy Interface
    interface PalindromeStrategy {
        boolean check(String input);
    }

    // Stack Strategy (Array)
    static class StackStrategy implements PalindromeStrategy {

        public boolean check(String input) {
            String str = input.replaceAll("\\s+", "").toLowerCase();
            int n = str.length();

            char[] stack = new char[n];
            int top = -1;

            // Push
            for (int i = 0; i < n; i++) {
                stack[++top] = str.charAt(i);
            }

            // Compare
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) != stack[top--]) {
                    return false;
                }
            }

            return true;
        }
    }

    // Deque Strategy
    static class DequeStrategy implements PalindromeStrategy {

        public boolean check(String input) {
            String str = input.replaceAll("\\s+", "").toLowerCase();

            Deque<Character> deque = new LinkedList<>();

            for (char c : str.toCharArray()) {
                deque.addLast(c);
            }

            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = sc.nextInt();
        sc.nextLine(); // fix input issue

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeStrategy strategy;

        // Runtime selection (Strategy Pattern)
        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        boolean result = strategy.check(input);

        if (result) {
            System.out.println("✅ It is a Palindrome");
        } else {
            System.out.println("❌ Not a Palindrome");
        }

        sc.close();
    }
}
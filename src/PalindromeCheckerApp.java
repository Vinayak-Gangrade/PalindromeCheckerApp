import java.util.*;

public class UseCase13PalindromeCheckerApp {

    // -------- Stack Method --------
    public static boolean stackCheck(String input) {
        String str = input.replaceAll("\\s+", "").toLowerCase();
        int n = str.length();

        char[] stack = new char[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            stack[++top] = str.charAt(i);
        }

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != stack[top--]) {
                return false;
            }
        }

        return true;
    }

    // -------- Deque Method --------
    public static boolean dequeCheck(String input) {
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

    // -------- Two Pointer Method (Fastest) --------
    public static boolean twoPointerCheck(String input) {
        String str = input.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // -------- Main Method --------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // STACK PERFORMANCE
        long start1 = System.nanoTime();
        boolean result1 = stackCheck(input);
        long end1 = System.nanoTime();

        // DEQUE PERFORMANCE
        long start2 = System.nanoTime();
        boolean result2 = dequeCheck(input);
        long end2 = System.nanoTime();

        // TWO POINTER PERFORMANCE
        long start3 = System.nanoTime();
        boolean result3 = twoPointerCheck(input);
        long end3 = System.nanoTime();

        // OUTPUT RESULTS
        System.out.println("\n--- Results ---");

        System.out.println("Stack Method: " + (result1 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Time: " + (end1 - start1) + " ns");

        System.out.println("\nDeque Method: " + (result2 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Time: " + (end2 - start2) + " ns");

        System.out.println("\nTwo Pointer Method: " + (result3 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Time: " + (end3 - start3) + " ns");

        sc.close();
    }
}
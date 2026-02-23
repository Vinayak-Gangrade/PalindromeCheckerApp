// UseCase7PalindromeCheckerApp.java

import java.util.*;

class UseCase7PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (char ch : text.toCharArray()) {
            deque.addLast(ch);
        }

        boolean isPalindrome = true;

        // Remove first & last and compare
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome)
            System.out.println("It is a Palindrome");
        else
            System.out.println("It is NOT a Palindrome");

        sc.close();
    }
}
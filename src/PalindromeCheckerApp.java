// UseCase9PalindromeCheckerApp.java

import java.util.Scanner;

class UseCase9PalindromeCheckerApp {

    static boolean isPalindrome(String str, int start, int end) {

        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        if (isPalindrome(text, 0, text.length() - 1))
            System.out.println("It is a Palindrome");
        else
            System.out.println("It is NOT a Palindrome");

        sc.close();
    }
}
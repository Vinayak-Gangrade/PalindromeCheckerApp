import java.util.Scanner;

class UseCase4PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Convert string to character array
        char[] arr = text.toCharArray();

        // Two-pointer technique
        int start = 0;
        int end = arr.length - 1;
        boolean isPalindrome = true;

        while (start < end) {

            if (arr[start] != arr[end]) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println("It is a Palindrome");
        } else {
            System.out.println("It is NOT a Palindrome");
        }

        sc.close();
    }
}
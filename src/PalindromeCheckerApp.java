// UseCase8PalindromeCheckerApp.java

import java.util.Scanner;

class UseCase8PalindromeCheckerApp {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    static void insert(char data) {
        Node newNode = new Node(data);
        if (head == null) head = newNode;
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
    }

    static Node reverse(Node node) {
        Node prev = null, current = node, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    static boolean isPalindrome() {

        if (head == null || head.next == null) return true;

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow.next);
        Node firstHalf = head;

        Node temp = secondHalf;
        boolean result = true;

        while (result && temp != null) {
            if (firstHalf.data != temp.data)
                result = false;
            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        for (char ch : text.toCharArray()) insert(ch);

        if (isPalindrome())
            System.out.println("It is a Palindrome");
        else
            System.out.println("It is NOT a Palindrome");

        sc.close();
    }
}

public class PalindromeTrainCode {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverse(Node head) {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        return previous;
    }

    public static boolean isPalindrome(Node head) {

        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null
                && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow.next);
        Node secondHalfCopy = secondHalf;

        boolean palindrome = true;
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                palindrome = false;
                break;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        slow.next = reverse(secondHalfCopy);

        return palindrome;
    }

    public static void display(Node head) {
        while (head != null) {
            System.out.print(head.data);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(2);
        head1.next.next.next.next = new Node(1);

        System.out.println("Train Code 1:");
        display(head1);
        System.out.println("Is Palindrome: "
                + isPalindrome(head1));
        System.out.println("After Checking:");
        display(head1);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(2);

        System.out.println("\nTrain Code 2:");
        display(head2);
        System.out.println("Is Palindrome: "
                + isPalindrome(head2));

        Node head3 = new Node(1);
        head3.next = new Node(2);
        head3.next.next = new Node(2);
        head3.next.next.next = new Node(1);

        System.out.println("\nTrain Code 3:");
        display(head3);
        System.out.println("Is Palindrome: "
                + isPalindrome(head3));
        System.out.println("After Checking:");
        display(head3);
    }
}

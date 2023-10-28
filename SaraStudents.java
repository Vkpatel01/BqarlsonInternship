import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SaraStudents {

    public static int maxChocolates(Node head) {
        if (head == null) {
            return 0;
        }

        int n = 0; // Count the number of nodes in the linked list
        Node current = head;

        while (current != null) {
            n++;
            current = current.next;
        }

        int[] chocolates = new int[n];

        // Populate the array with the chocolates from the linked list
        current = head;
        for (int i = 0; i < n; i++) {
            chocolates[i] = current.data;
            current = current.next;
        }

        int[][] dp = new int[n][n];

        // Fill the dp table with the maximum chocolates a student can get
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                int x = (i + 2 <= j) ? dp[i + 2][j] : 0;
                int y = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                int z = (i <= j - 2) ? dp[i][j - 2] : 0;

                dp[i][j] = Math.max(chocolates[i] + Math.min(x, y), chocolates[j] + Math.min(y, z));
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input for the linked list
        int n = scanner.nextInt();
        Node head = new Node(scanner.nextInt());
        Node current = head;

        for (int i = 1; i < 2 * n; i++) {
            current.next = new Node(scanner.nextInt());
            current = current.next;
        }

        // Calculate and print the result
        int result = maxChocolates(head);
        System.out.println(result);
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class CheckIfSinglyLinkedListIsEmpty {

    static boolean checkIfEmpty(Node head) {
        return head == null;
    }

    public static void main(String[] args) {
        Node head = null;

        System.out.println(checkIfEmpty(head));

        head = new Node(8);

        System.out.println(checkIfEmpty(head));
    }
}
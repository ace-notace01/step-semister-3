class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class RemoveFirstKNodes {

    static Node removeFirstKNodes(Node head, int k) {
        for (int i = 0; i < k && head != null; i++) {
            head = head.next;
        }

        return head;
    }

    static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = removeFirstKNodes(head, 2);
        display(head);

        head = removeFirstKNodes(head, 5);
        display(head);
    }
}
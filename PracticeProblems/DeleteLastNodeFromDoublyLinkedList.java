class DNode {
    int data;
    DNode prev;
    DNode next;

    DNode(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}

public class DeleteLastNodeFromDoublyLinkedList {

    static DNode deleteLastNodeDoubly(DNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return null;
        }

        DNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
        temp.prev = null;

        return head;
    }

    static void display(DNode head) {
        DNode temp = head;

        if (temp == null) {
            System.out.println("Empty list");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data);

            if (temp.next != null) {
                System.out.print(" <-> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        DNode head = new DNode(1);
        head.next = new DNode(2);
        head.next.prev = head;
        head.next.next = new DNode(3);
        head.next.next.prev = head.next;

        head = deleteLastNodeDoubly(head);
        display(head);

        DNode single = new DNode(5);
        single = deleteLastNodeDoubly(single);
        display(single);

        DNode empty = null;
        empty = deleteLastNodeDoubly(empty);
        display(empty);
    }
}

package Week5.AssignmentProblems;

public class BookInventory {

    private final int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {

        if (copiesTotal < 0) {
            copiesTotal = 0;
        }

        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }


    public void checkOut() {

        // Nothing available
        if (copiesAvailable <= 0) {
            return;
        }

        copiesAvailable--;
    }


    public void checkIn() {

        // Already at full capacity
        if (copiesAvailable >= copiesTotal) {
            return;
        }

        copiesAvailable++;
    }


    public int getCopiesAvailable() {
        return copiesAvailable;
    }


    public static void main(String[] args) {

        BookInventory b = new BookInventory(3);

        b.checkOut();
        b.checkOut();
        b.checkOut();
        b.checkOut();

        System.out.println(b.getCopiesAvailable());


        BookInventory b2 = new BookInventory(3);

        b2.checkIn();
        b2.checkIn();
        b2.checkIn();
        b2.checkIn();

        System.out.println(b2.getCopiesAvailable());
    }
}
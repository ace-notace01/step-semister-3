abstract class ArtPiece {
    static int counter = 1000;
    final String pieceId;
    String title;

    ArtPiece(String title) {
        this.title = title;
        counter++;
        pieceId = "ART-" + counter;
    }

    abstract String describe();

    String getPieceId() {
        return pieceId;
    }
}

class Painting extends ArtPiece {
    Painting(String title) {
        super(title);
    }

    @Override
    String describe() {
        return "Painting: " + title + ", framed on canvas";
    }
}

class Sculpture extends ArtPiece {
    Sculpture(String title) {
        super(title);
    }

    @Override
    String describe() {
        return "Sculpture: " + title + ", carved from stone";
    }
}

public class GalleryDescriptionCards {
    public static void main(String[] args) {
        Painting p = new Painting("Sunset Fields");
        Sculpture s = new Sculpture("The Thinker II");

        System.out.println(p.describe());
        System.out.println(s.describe());

        System.out.println(p.getPieceId());
        System.out.println(s.getPieceId());
    }
}
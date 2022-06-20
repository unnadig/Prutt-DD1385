
public class Move {
    private Piece piece;
    private Square startSquare;
    private Square endSquare;

    public Move(Square startSquare, Square endSquare) {
        this.piece = startSquare.getPiece();
        this.startSquare = startSquare;
        this.endSquare = endSquare;
    }

    public Piece getPiece() {
        return piece;
    }

    public Square getStartSquare() {
        return startSquare;
    }

    public Square getEndSquare() {
        return endSquare;
    }


}

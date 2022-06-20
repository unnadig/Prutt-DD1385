public class Knight extends Piece {

    public Knight(PieceColor pieceColor) {
        super(pieceColor);
    }

    @Override
    public boolean moveOK(Board board, Square s1, Square s2) {
        return squareDiff(s1, s2, true)*squareDiff(s1, s2, false) == 2;
    }
    
}

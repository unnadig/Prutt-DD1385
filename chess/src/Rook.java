public class Rook extends Piece {

    public Rook(PieceColor pieceColor) {
        super(pieceColor);
    }

    @Override
    public boolean moveOK(Board board, Square s1, Square s2) {
        boolean squareReachable = squareDiff(s1, s2, true)*squareDiff(s1, s2, false) == 0;
        return squareReachable && validStraightPath(board, s1, s2);
    }
    
}

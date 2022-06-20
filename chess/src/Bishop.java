public class Bishop extends Piece{

    public Bishop(PieceColor pieceColor) {
        super(pieceColor);
    }

    @Override
    public boolean moveOK(Board board, Square s1, Square s2) {
        boolean squareReachable = (squareDiff(s1, s2, true) == squareDiff(s1, s2, false));
        return squareReachable && validDiagonalPath(board, s1, s2);
    }
    
}

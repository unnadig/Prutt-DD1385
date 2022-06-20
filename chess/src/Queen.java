public class Queen extends Piece {

    public Queen(PieceColor pieceColor) {
        super(pieceColor);
    }

	@Override
	public boolean moveOK(Board board, Square s1, Square s2) {
		boolean squareDiagReachable = (squareDiff(s1, s2, true) == squareDiff(s1, s2, false));
		boolean squareRookReachable = squareDiff(s1, s2, true)*squareDiff(s1, s2, false) == 0;
		return (squareDiagReachable && validDiagonalPath(board, s1, s2)) ||
				(squareRookReachable && validStraightPath(board, s1, s2));
	}
    
}

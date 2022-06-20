
public class King extends Piece {
    
    private boolean castlingDone = false;

    public King(PieceColor pieceColor) {
        super(pieceColor);
        
    }
    
    @Override
    public boolean moveOK(Board board, Square s1, Square s2) {
        boolean squareReachable = (squareDiff(s1, s2) == 1 &&
        squareDiff(s1, s2, true)*squareDiff(s1, s2, false) == 0)
        || (squareDiff(s1, s2, true) == 1 && squareDiff(s1, s2, false) == 1);

        return squareReachable;
        // TODO implement castling
    }

    public boolean isCastlingDone() {
        return castlingDone;
    }

    public void setCastlingDone(boolean castlingDone) {
        this.castlingDone = castlingDone;
    }

}
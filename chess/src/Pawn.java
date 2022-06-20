public class Pawn extends Piece {
    private boolean moved;

    public Pawn(PieceColor pieceColor) {
        super(pieceColor);
        moved = false;
    }

    @Override
    public boolean moveOK(Board board, Square s1, Square s2) {
        boolean advance = advanceOK(board, s1, s2);
        boolean capture = captureOK(board, s1, s2);
        // TODO implement promotion
        // TODO implement en passant
        if (advance || capture) {
            moved = true;
            return true;
        }
        return false;
    }

    public boolean advanceOK(Board board, Square s1, Square s2) {
        if (s1.getX() != s2.getX()) {
            return false;
        }

        if (s2.getPiece() != null) {
            return false;
        }

        int move;
        if (getPieceColor() == PieceColor.WHITE) {
            move = 1;
        } else {
            move = -1;
        }

        if (s2.getY() - s1.getY() == move) {
            return true;
        } else if (s2.getY() - s1.getY() == 2*move) {
            return !moved && validStraightPath(board, s1, s2);
        } else {
            return false;
        }

    }

    public boolean captureOK(Board board, Square s1, Square s2) {
        if (Math.abs(s2.getX() - s1.getX()) != 1) {
            return false;
        }

        int move;
        if (getPieceColor() == PieceColor.WHITE) {
            move = 1;
        } else {
            move = -1;
        }

        if (s2.getY() - s1.getY() == move) {
            return s2.getPiece() != null &&
                   s2.getPiece().getPieceColor() != getPieceColor();
        }

        return false;
    }
    
}

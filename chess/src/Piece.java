
public abstract class Piece {
    private PieceColor pieceColor;
    private boolean killed = false;
    
    public Piece(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public abstract boolean moveOK(Board board, Square s1, Square s2);
    
    public static int squareDiff(Square s1, Square s2) {
        return Math.abs((s1.getX() + s1.getY()) - (s2.getX() + s2.getY()));
    }
    
    public static int squareDiff(Square s1, Square s2, boolean alongXAxis) {
        if (alongXAxis) {
            return Math.abs(s1.getX() - s2.getX());
        } else {
            return Math.abs(s1.getY() - s2.getY());
        }
        
    }
    
    // checks if squares in between s1 and s2 are unoccupied
    public boolean validStraightPath(Board board, Square s1, Square s2) {
        int lowX = Math.min(s1.getX(), s2.getX());
        int highX = Math.max(s1.getX(), s2.getX());
        int lowY = Math.min(s1.getY(), s2.getY());
        int highY = Math.max(s1.getY(), s2.getY());
        
        if (lowX == highX) {
            for (int i = lowY+1; i < highY; i++) {
                if (board.getSquare(lowX, i).getPiece() != null) {
                    return false;
                }
            }
        } else if (lowY == highY) {
            for (int i = lowX+1; i < highX; i++) {
                if (board.getSquare(i, lowY).getPiece() != null) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }

    // checks if squares in between s1 and s2 are unoccupied
    public boolean validDiagonalPath(Board board, Square s1, Square s2) {
        int lowX = Math.min(s1.getX(), s2.getX());
        int highX = Math.max(s1.getX(), s2.getX());
        int lowY = Math.min(s1.getY(), s2.getY());
        int highY = Math.max(s1.getY(), s2.getY());
        boolean ascendingDiag = (lowX == s1.getX() && lowY == s1.getY()) || (lowX == s2.getX() && lowY == s2.getY());
        int y;
        for (int i = 1; i < highX-lowX; i++) {
            if (ascendingDiag) {
                y = lowY + i;
            } else {
                y = highY - i;
            }
            
            if (board.getSquare(lowX+i,y).getPiece() != null) {
                return false;
            }   

        }

        return true;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }
    
}


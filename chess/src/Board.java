import java.util.List;

public class Board {
    private Square[][] squares = new Square[8][8];
    private PieceSet[] pieceSets;
    
    Board() {
        pieceSets = new PieceSet[]{new PieceSet(PieceColor.WHITE), new PieceSet(PieceColor.BLACK)};
        resetBoard();
    }

    public void resetBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 2; j < 6; j++) {
                squares[i][j] = new Square(i, j, null);
                
            }
            
            int k, l;
            for (PieceSet pieceSet : pieceSets) {
                List<Piece> pieceList = pieceSet.getPieceList();
                PieceColor pieceColor = pieceSet.getColor();
                if (pieceColor == PieceColor.WHITE) {
                    k = 0;
                    l = 1;
                } else {
                    k = 8;
                    l = 7;
                }
                squares[i][k] = new Square(i, k, pieceList.get(i));
                squares[i][l] = new Square(i, l, pieceList.get(i+8));
            }
            
        }
            
    }

    public Square getSquare(int x, int y) {
        return squares[x][y];
    }

}

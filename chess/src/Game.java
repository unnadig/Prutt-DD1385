//import java.util.ArrayList;
//import java.util.List;
 
public class Game {
    private Board board;
    //private List<Move> moveHistory;
    //private GameStatus status;
    private PieceColor currentTurn;

    public Game() {
        this.board = new Board();
        //this.moveHistory = new ArrayList<Move>();
        //this.status = GameStatus.ACTIVE;
        this.currentTurn = PieceColor.WHITE;

    }
    // TODO give list of possible moves

    public boolean makeMove(int startX, int startY, int endX, int endY) {
        Square startSquare = board.getSquare(startX, startY);
        Square endSquare = board.getSquare(endX, endY);
        Piece sourcePiece = startSquare.getPiece();
        Piece destPiece = endSquare.getPiece();
        // valid start piece?
        if (sourcePiece == null) {
            return false;
        }
        
        if (sourcePiece.getPieceColor() != currentTurn) {
            return false;
        }
        
        // valid move?
        if (startSquare == endSquare) {
            return false;
        }
        
        if (sourcePiece.getPieceColor() == destPiece.getPieceColor()) {
            return false;
        }
        
        if (!sourcePiece.moveOK(board, startSquare, endSquare)) {
            return false;
        }
        // TODO make sure own king not in check after move
        
        // kill?
        if (destPiece != null) {
            destPiece.setKilled(true);   
        }
        
        // move piece
        endSquare.setPiece(sourcePiece);
        startSquare.setPiece(null);
        //moveHistory.add(new Move(startSquare, endSquare));

        // switch turn
        if (currentTurn == PieceColor.WHITE) {
            currentTurn = PieceColor.BLACK;
        } else if (currentTurn == PieceColor.BLACK) {
            currentTurn = PieceColor.WHITE;
        }

        return true;
    }

}

import java.util.ArrayList;
import java.util.List;

public class PieceSet {
    private List<Piece> pieceList;

    private PieceColor pieceColor;

    public PieceSet(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
        pieceList = generatePieceList();
    }

    public List<Piece> generatePieceList() {
        List<Piece> pieceList = new ArrayList<Piece>(16);
        pieceList.add(new Rook(pieceColor));
        pieceList.add(new Knight(pieceColor));
        pieceList.add(new Bishop(pieceColor));
        pieceList.add(new Queen(pieceColor));
        pieceList.add(new King(pieceColor));
        pieceList.add(new Bishop(pieceColor));
        pieceList.add(new Knight(pieceColor));
        pieceList.add(new Rook(pieceColor));
        
        for (int i = 0; i < 7; i++) {
            pieceList.add(new Pawn(pieceColor));    
        }

        return pieceList;
        
    }

    public PieceColor getColor() {
        return pieceColor;
    }
    public List<Piece> getPieceList() {
        return pieceList;
    }
    
}

public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;
        if (toLine == line || toColumn == column) {
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}

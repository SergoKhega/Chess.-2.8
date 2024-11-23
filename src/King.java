public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;
        if (Math.abs(toLine - line) <= 1 && Math.abs(toColumn - column) <= 1) {
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}

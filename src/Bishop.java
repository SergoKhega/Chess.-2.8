public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;
        if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}

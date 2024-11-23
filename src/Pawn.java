public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;
        int direction = color.equals("White") ? 1 : -1;
        if (column == toColumn) {
            if (toLine == line + direction) return true;
            if ((line == 1 && color.equals("White") && toLine == line + 2 * direction) ||
                    (line == 6 && color.equals("Black") && toLine == line + 2 * direction)) {
                return true;
            }
        } else if (Math.abs(toColumn - column) == 1 && toLine == line + direction) {
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}

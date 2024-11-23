public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8];
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
        initializeBoard();
    }

    private void initializeBoard() {
        board[0][0] = new Rook("White");
        board[0][1] = new Horse("White");
        board[0][2] = new Bishop("White");
        board[0][3] = new Queen("White");
        board[0][4] = new King("White");
        board[0][5] = new Bishop("White");
        board[0][6] = new Horse("White");
        board[0][7] = new Rook("White");
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("White");
            board[6][i] = new Pawn("Black");
        }
        board[7][0] = new Rook("Black");
        board[7][1] = new Horse("Black");
        board[7][2] = new Bishop("Black");
        board[7][3] = new Queen("Black");
        board[7][4] = new King("Black");
        board[7][5] = new Bishop("Black");
        board[7][6] = new Horse("Black");
        board[7][7] = new Rook("Black");
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {
            if (board[startLine][startColumn] == null) return false;
            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                if (board[endLine][endColumn] != null &&
                        !board[endLine][endColumn].getColor().equals(nowPlayer)) {
                    board[endLine][endColumn] = board[startLine][startColumn];
                    board[startLine][startColumn] = null;
                    this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";
                    return true;
                } else if (board[endLine][endColumn] == null) {
                    board[endLine][endColumn] = board[startLine][startColumn];
                    board[startLine][startColumn] = null;
                    this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";
                    return true;
                }
            }
        }
        return false;
    }

    public void printBoard() {
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard("White");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите команду ''move' + координаты' для передвижения фигур. Например: 'move 1 0 3 0'. Введите 'exit' для выхода.");
        board.printBoard();

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("exit")) break;
            else if (command.startsWith("move")) {
                String[] parts = command.split(" ");
                int startLine = Integer.parseInt(parts[1]);
                int startColumn = Integer.parseInt(parts[2]);
                int endLine = Integer.parseInt(parts[3]);
                int endColumn = Integer.parseInt(parts[4]);
                if (board.moveToPosition(startLine, startColumn, endLine, endColumn)) {
                    System.out.println("Ход выполнен.");
                } else {
                    System.out.println("Неверный ход.");
                }
                board.printBoard();
            }
        }
        scanner.close();
    }
}

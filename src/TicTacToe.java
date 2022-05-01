import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    final char SIGN_X = 'X';
    final char SIGN_O = 'O';
    final char SIGN_EMPTY = '.';
    char[][] field;
    Random random;
    Scanner scanner;

    public static void main(String[] args) {
        new TicTacToe().game();
    }

    public TicTacToe() {
        random = new Random();
        scanner = new Scanner(System.in);
        field = new char[3][3];
    }

    void game() {
        initField();
        while (true) {
            turnHuman();
            System.out.println("You win!");
            break;
        }
        if (isTableFull()) {
            System.out.println("Sorry, draw");
        }
        turnAl();
        printField();
        if(checkWin(SIGN_O)){
            System.out.println("Al win");
        }
        if (isTableFull()){
            System.out.println("Sorry, draw");
        }
      System.out.println("GAME OVER.");
        printField();
}

    void initField() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                field[row][col] = SIGN_EMPTY;
            }
        }
    }

    void printField() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(field[row][col] + "  ");
                System.out.println();
            }
        }
    }

    void turnHuman() {
        int x, y;
        do {
            System.out.println("Enter x and y (1..3 ): ");
            x = scanner.nextInt();
            y = scanner.nextInt();
        } while (!isCellValid(x, y));
        field[x][y] = SIGN_X;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > 3 || y > 3) {
            return field[x][y] == SIGN_EMPTY;
        }
        return false;
    }

    void turnAl() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        field[x][y] = SIGN_O;
    }

    boolean checkWin(char dot) {
        for (int i = 0; i < 3; i++) {
            if ((field[i][0] == dot && field[i][1] == dot && field[i][2] == dot)
                    || (field[0][i] == dot && field[1][i] == dot && field[2][i] == dot))
                return true;
            if ((field[0][0] == dot && field[1][1] == dot && field[2][2] == dot) ||
                    (field[2][0] == dot && field[1][1] == dot && field[0][2] == dot))
                return true;
        }
        return false;
    }

    boolean isTableFull(){
        for(int i = 0; i < 3; i++){
            for (int row = 0; row < 3; row++){
                for ( int col = 0; col < 3; col++){
                    if(field[row][col] == SIGN_EMPTY){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

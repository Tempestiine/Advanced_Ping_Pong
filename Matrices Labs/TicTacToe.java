//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class TicTacToe {
    private char[][] mat;

    public TicTacToe() {
        mat = new char[3][3];
    }

    public TicTacToe(String game) {
        mat = new char[3][3];
        for (int i = 0; i < 9; i++) {
            mat[i / 3][i % 3] = game.charAt(i);
        }
    }

    private int checkWinner() {
        // Check for horizontal win
        for (int i = 0; i < 3; i++)
            if (mat[i][0] != ' ' && mat[i][0] == mat[i][1] && mat[i][1] == mat[i][2])
                return 1;
        // Check for vertical win
        for (int i = 0; i < 3; i++)
            if (mat[0][i] != ' ' && mat[0][i] == mat[1][i] && mat[1][i] == mat[2][i])
                return 2;
        // Check for diagonal win
        if (mat[0][0] != ' ' && mat[0][0] == mat[1][1] && mat[1][1] == mat[2][2])
            return 3;
        if (mat[0][2] != ' ' && mat[0][2] == mat[1][1] && mat[1][1] == mat[2][0])
            return 4;
        // Check for a tie
        boolean tie = true;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (mat[i][j] == ' ') {
                    tie = false;
                    break;
                }

        int result;
        if (tie)
            result = 5;
        else
            result = 0;
        return result;
    }

    public String getWinner() {
        int result = checkWinner();
        switch (result) {
            case 1:
                return mat[0][0] + " wins horizontally!";
            case 2:
                return mat[0][0] + " wins vertically!";
            case 3:
                return mat[0][0] + " wins diagonally!";
            case 4:
                return mat[0][2] + " wins diagonally!";
            case 5:
                return "cat's game - no winner!";
            default:
                return "";
        }
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result += mat[i][j];
                if (j < 2) {
                    result += " ";
                }
            }
            result += "\n";
        }
        return result;
    }
}

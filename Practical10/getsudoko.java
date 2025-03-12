import java.util.*;
class Suduko {
    static String getSuduko(int Size) {
        String[][] grid = new String[Size][Size];

        Random random = new Random();
        int Num = random.nextInt(Size) + 1;
        int num = Num;
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                if (num > Size) {
                    num = num % Size;
                }
                grid[i][j] = num + "";
                num++;
            }
            num++;
        }
        int empty = (Size * Size) / 3;
        while (empty > 0) {
            for (int i = 0; i < Size && empty > 0; i++) {
                for (int j = 0; j < Size && empty > 0; j++) {
                    int randValue = random.nextInt(Size);
                    if (randValue == 0 && !grid[i][j].equals(" ")) {
                        grid[i][j] = " ";
                        empty--;
                    }
                }
            }
        }
        StringBuilder output = new StringBuilder();
        int Width = String.valueOf(Size).length() + 1;
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                output.append("-".repeat(Width + 1));
            }
            output.append("\n");
            for (int j = 0; j < Size; j++) {
                output.append("|");
                if (grid[i][j].isEmpty()) {
                    output.append(" ".repeat(Width));
                } else {
                    output.append(String.format("%-" + Width + "s", grid[i][j]));
                }
            }
            output.append("|\n");
        }
        output.append("-".repeat(Size * (Width + 1)));
        return output.toString();
    }
    public static void main(String[] args) {
        int Size = Integer.parseInt(args[0]);
        System.out.println(getSuduko(Size));
    }
}
import java.util.Scanner;

class version2 {
    String[][] gridLayout, userAnswers;
    int[] removedIndices;
    int gridSize, cellsToRemove;
    Scanner scanner;

    version2(int gridSize) {
        this.gridSize = gridSize;
        this.scanner = new Scanner(System.in);
        initializeGridLayout();
        chooseDifficulty();
        removeRandomCells();
        displayGrid();
        getUserAnswers();

        if (checkSolution()) {
            System.out.println("solved");
        } else {
            System.out.println("Wrong");
        }
    }

    void displayGrid() {
        for (int row = 1; row <= (gridSize * 2) + 1; row++) {
            for (int col = 1; col <= (gridSize * 2) + 1; col++) {
                if (row % 2 == 1) {
                    if (col % 2 == 1) {
                        System.out.print(" ");
                    } else {
                        System.out.print("__");
                    }
                } else {
                    if (col % 2 == 1) {
                        System.out.print("|");
                    } else {
                        String value = gridLayout[(row / 2) - 1][(col / 2) - 1];
                        if (value.length() == 1) {
                            System.out.print(" ");
                        }
                        System.out.print(value);
                    }
                }
            }
            System.out.println();
        }
    }

    int[] getNumbers() {
        int[] numbers = new int[gridSize];
        for (int i = 0; i < gridSize; i++) {
            numbers[i] = i + 1;
        }
        return numbers;
    }

    void initializeGridLayout() {
        gridLayout = new String[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            int[] numbers = getNumbers();
            for (int j = 0; j < gridSize; j++) {
                boolean validPlacement = false;
                while (!validPlacement) {
                    int num = numbers[(int) (Math.random() * gridSize)];

                    if (isValidPlacement(i, j, num)) {
                        gridLayout[i][j] = Integer.toString(num);
                        validPlacement = true;
                    }
                }
            }
        }
    }

    boolean isValidPlacement(int row, int col, int num) {
        // Check the row
        for (int i = 0; i < gridSize; i++) {
            if (gridLayout[row][i] != null && Integer.parseInt(gridLayout[row][i]) == num) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < gridSize; i++) {
            if (gridLayout[i][col] != null && Integer.parseInt(gridLayout[i][col]) == num) {
                return false;
            }
        }

        return true;
    }

    void chooseDifficulty() {
        System.out.println("difficulty:\n1. easy\n2. medium\n3. hard");

        boolean valid = false;
        while (!valid) {
            String level = scanner.nextLine();

            switch (level) {
                case "1":
                    cellsToRemove = (gridSize * gridSize) / 3;
                    valid = true;
                    break;
                case "2":
                    cellsToRemove = (gridSize * gridSize) / 2;
                    valid = true;
                    break;
                case "3":
                    cellsToRemove = (gridSize * gridSize) * 3 / 4;
                    valid = true;
                    break;
                default:
                    System.out.println("wrong");
                    break;
            }
        }
    }
    void removeRandomCells() {
        removedIndices = new int[2 * cellsToRemove];
        for (int deleteCount = 0; deleteCount < cellsToRemove; deleteCount++) {
            int i = (int) (Math.random() * gridSize);
            int j = (int) (Math.random() * gridSize);
            if (gridLayout[i][j].equals(" ")) {
                deleteCount--;
                continue;
            }
            gridLayout[i][j] = " ";
            removedIndices[2 * deleteCount] = i + 1;
            removedIndices[2 * deleteCount + 1] = j + 1;
        }
    }
    void getUserAnswers() {
        userAnswers = new String[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            userAnswers[i] = new String[gridSize];
            System.arraycopy(gridLayout[i], 0, userAnswers[i], 0, gridSize);
        }

        for (int i = 0; i < cellsToRemove; i++) {
            System.out.println("Z: Undo");
            System.out.println("enter value for row " + removedIndices[2 * i] + ", col " + removedIndices[2 * i + 1]);

            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("z") && i > 0) {
                gridLayout[removedIndices[2 * (i - 1)] - 1][removedIndices[2 * (i - 1) + 1] - 1] = " ";
                displayGrid();
                i -= 2;
                continue;
            } else if (!input.matches("\\d+")) {
                System.out.println("Invalid enter a number between 1 and " + gridSize);
                i--;
                continue;
            } else if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > gridSize) {
                System.out.println("Invalid enter a number between 1 and " + gridSize);
                i--;
                continue;
            }
            gridLayout[removedIndices[2 * i] - 1][removedIndices[2 * i + 1] - 1] = input;
            displayGrid();
        }
    }
    boolean checkSolution() {
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                for (int checkCol = 0; checkCol < gridSize; checkCol++) {
                    if (checkCol == col) continue;
                    if (userAnswers[row][checkCol].equals(userAnswers[row][col])) {
                        return false;
                    }
                }

                for (int checkRow = 0; checkRow < gridSize; checkRow++) {
                    if (checkRow == row) continue;
                    if (userAnswers[checkRow][col].equals(userAnswers[row][col])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        version2 game = new version2(Integer.parseInt(args[0]));
    }
}
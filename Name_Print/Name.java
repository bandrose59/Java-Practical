public class Name{
    public static void main(String[] args) {
        Name ritu = new Name();
        int size = 7; // You can adjust the size as needed
        ritu.displayRITESH(size);
    }

    void displayRITESH(int size) {
        for (int row = 1; row <= size; row++) {
            displayRRow(row, size);
            System.out.print("  ");
            displayIRow(row, size);
            System.out.print("  ");
            displayTRow(row, size);
            System.out.print("  ");
            displayERow(row, size);
            System.out.print("  ");
            displaySRow(row, size);
            System.out.print("  ");
            displayHRow(row, size);
            System.out.println();
        }
    }

    void displayRRow(int row, int size) {
        for (int col = 1; col <= size; col++) {
            if (col == 1) {
                System.out.print(" #");
            } else if (col < size && col > 1 && row == 1) {
                System.out.print(" #");
            } else if (col == size && row < size / 2 && row > 1) {
                System.out.print(" #");
            } else if (row == size / 2 && col < size) {
                System.out.print(" #");
            } else if (row >= size / 2 && row - col == 0) {
                System.out.print(" #");
            } else {
                System.out.print("  ");
            }
        }
    }

    void displayIRow(int row, int size) {
        for (int col = 1; col <= size; col++) {
            if (row == 1 || row == size || col == size / 2 + 1) {
                System.out.print(" #");
            } else {
                System.out.print("  ");
            }
        }
    }

    void displayTRow(int row, int size) {
        for (int col = 1; col <= size; col++) {
            if (row == 1 || col == size / 2 + 1) {
                System.out.print(" #");
            } else {
                System.out.print("  ");
            }
        }
    }

    void displayERow(int row, int size) {
        for (int col = 1; col <= size; col++) {
            if (row == 1 || row == size || row == size / 2 + 1 || col == 1) {
                System.out.print(" #");
            } else {
                System.out.print("  ");
            }
        }
    }

    void displaySRow(int row, int size) {
        for (int col = 1; col <= size; col++) {
            if (row == 1 || row == size || (row == size / 2 + 1) || (col == 1 && row <= size / 2) || (col == size && row > size / 2)) {
                System.out.print(" #");
            } else {
                System.out.print("  ");
            }
        }
    }

    void displayHRow(int row, int size) {
        for (int col = 1; col <= size; col++) {
            if (col == 1 || col == size || (row == size / 2 + 1)) {
                System.out.print(" #");
            } else {
                System.out.print("  ");
            }
        }
    }
}
public class Matrix {
    private int rows;
    private int columns;
    private int[][] matrix;

    // Constructor to initialize the dimensions of the matrix
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
    }

    // Method to fill the matrix with values
    public void fillMatrix(int[][] values) {
        if (values.length != rows || values[0].length != columns) {
            System.out.println("Invalid dimensions for input values.");
            return;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = values[i][j];
            }
        }
    }

    // Method to print the matrix
    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Getter methods for rows and columns
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    // Getter method to access individual elements of the matrix
    public int getElement(int row, int column) {
        return matrix[row][column];
    }

    // Setter method to set individual elements of the matrix
    public void setElement(int row, int column, int value) {
        matrix[row][column] = value;
    }

    // Example of usage
    public static void main(String[] args) {
        // Create a 3x3 matrix
        Matrix matrix = new Matrix(3, 3);

        // Fill the matrix with values
        int[][] values = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        matrix.fillMatrix(values);

        // Print the matrix
        matrix.printMatrix();
    }
}

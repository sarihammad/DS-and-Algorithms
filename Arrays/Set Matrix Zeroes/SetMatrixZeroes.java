// For constant space, use the first column and row as a store for the rows and cols to zero out instead of a set. Make sure to store whether first col or row needs zeroing since we'll lose that info.
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: Check if first row or col needs zeroing
        boolean zeroFirstRow = false;
        boolean zeroFirstCol = false;
        for (int c = 0; c < cols; c++) {
            if (matrix[0][c] == 0) {
                zeroFirstRow = true;
                break;
            }
        }

        for (int r = 0; r < rows; r++) {
            if (matrix[r][0] == 0) {
                zeroFirstCol = true;
                break;
            }
        }

        // Step 2: Traverse and mark zeros for other rows and cols
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        // Step 3: Zero out rows and cols
        for (int c = 1; c < cols; c++) {
            if (matrix[0][c] == 0) {
                for (int r = 0; r < rows; r++) matrix[r][c] = 0;
            }
        }

        for (int r = 1; r < rows; r++) {
            if (matrix[r][0] == 0) {
                for (int c = 0; c < cols; c++) matrix[r][c] = 0;
            }
        }

        // Step 4: Zero out first row and col if needed
        if (zeroFirstRow) {
            for (int c = 0; c < cols; c++) matrix[0][c] = 0;
        }

        if (zeroFirstCol) {
            for (int r = 0; r < rows; r++) matrix[r][0] = 0;
        }
    }
}

package leetcode.Labuladong.A_DataStructure.A_prefixSum;
public class NumMatrix_304 {

    public int[][] matrixSum;

    public int[][] getMatrixSum() {
        return matrixSum;
    }

    public void NumMatrixTest(int[][] matrix) {
        if (matrix.length > 0) {

            int rows = matrix.length, cols = matrix[0].length;

            matrixSum = new int[rows + 1][cols + 1];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrixSum[i + 1][j + 1] = matrix[i][j] +
                            matrixSum[i + 1][j] + matrixSum[i][j + 1]
                            - matrixSum[i][j];
                }
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        StringBuilder computeSB = new StringBuilder();
        computeSB.append("compute:").append(matrixSum[row2 + 1][col2 + 1]).append("-").append(matrixSum[row2 + 1][col1])
                .append("-").append(matrixSum[col1][col2 + 1]).append("+").append(matrixSum[row1][col1]);
        System.out.println(computeSB.toString());
        return matrixSum[row2 + 1][col2 + 1]
                - matrixSum[row2 + 1][col1] - matrixSum[row1][col2 + 1]
                + matrixSum[row1][col1];
    }

    public static void main(String[] args) {
        // int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },{ 1, 0, 3, 0, 5 } };
        // NumMatrixTest numMatrix = new NumMatrixTest(matrix);
        // int[][] matrixSum = numMatrix.getMatrixSum();
        // for (int[] matrixOne : matrixSum) {
        //     System.out.println(Arrays.stream(matrixOne).boxed().collect(Collectors.toList()));
        // }
        // numMatrix.sumRegion(2, 1, 4, 3);
    }
    
}

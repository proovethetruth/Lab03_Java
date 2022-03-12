package MatrixClass;

public class SquareMatrix extends Matrix {
    public SquareMatrix(int n) {
        if(n <= 0)
            throw new MatrixExeption("Incorrect input. Width and length must be bigger than zero");
        matrix = new int[n][n];
        length = width = n;
        for(int i = 0; i < length; i++) {
                matrix[i][i] = 1;
        }
    }

    final public Matrix sum(Matrix input) {
        Matrix result = new SquareMatrix(length);
        if((this.length != input.length) || (this.width != input.width))
            throw new MatrixExeption("Incorrect arguments. Two matrices must have an equal number of rows and columns to be added.");

        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                result.setElement(i, j, matrix[i][j] + input.getElement(i, j));
            }
        }
        return result;
    }
}

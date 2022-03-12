
package MatrixClass;

public class Matrix {
    int matrix[][];
    int length = 0;
    int width = 0;

    Matrix() {
        length = 1;
        width = 1;
        matrix = new int[length][width];
    }

    public Matrix(int a, int b) throws MatrixExeption {
        length = a;
        width = b;
        if(width <= 0 || length <= 0)
            throw new MatrixExeption("Incorrect input. Width and length must be bigger than zero");
        matrix = new int[length][width];
    }

    final public boolean Equals(Matrix input) {
        if((width != input.width) || (length != input.length))
            return false;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < width; j++) {
                if(matrix[i][j] != input.matrix[i][j])
                    return false;
            }
        }
        return true;
    }
    
    final public void setElement(int row, int column, int value) throws MatrixExeption {
        if((row < 0) || (column < 0))
            throw new MatrixExeption("Incorrect input. Row and column must be bigger of equal to zero");
        matrix[row][column] = value;
    }

    final public int getElement(int row, int column) {
        if((row < 0) || (column < 0))
            throw new MatrixExeption("Incorrect input. Row and column must be bigger of equal to zero");
        return matrix[row][column];
    }

    final public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < width; j++) {
                str.append(matrix[i][j]);
                str.append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    final public Matrix product(Matrix input) {
        if((input.width != this.length))
            throw new MatrixExeption("Incorrect arguments. Width of the first matrix must be equal to length of the second matrix");
        Matrix result = new SquareMatrix(length);
        int tmp = 0;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < input.width; j++) {
                for(int k = 0; k < length; k++) {
                    tmp += matrix[i][k] * input.getElement(k, j);
                }
                result.setElement(i, j, tmp);
                tmp = 0;
            }
        }
        return result;
    }

    public Matrix sum(Matrix input) {
        Matrix result = new Matrix(length, width);
        if((this.length != input.length) || (this.width != input.width))
            throw new MatrixExeption("Incorrect arguments. Two matrices must have an equal number of rows and columns to be added.");
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < width; j++) {
                result.setElement(i, j, matrix[i][j] + input.getElement(i, j));
            }
        }
        return result;
    }
}

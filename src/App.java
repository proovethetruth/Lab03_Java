import MatrixClass.Matrix;
import MatrixClass.SquareMatrix;

public class App {
    public static void main(String[] args) {
        Matrix a = new Matrix(2, 3);
        Matrix b = new Matrix(3, 2);
        b.setElement(1, 1, 7);
        a.setElement(1, 1, 8);
        System.out.println(a.toString());
        System.out.println(b.toString());
            
        Matrix c = a.product(b);
        System.out.println(c.toString());

        Matrix first = new Matrix(2, 2);
        Matrix second = new Matrix(2, 2);
        first.setElement(1, 1, 8);
        second.setElement(1, 1, 8);

        if(first.equals(second));
            System.out.println("\nEqual.\n");

        Matrix q = new Matrix(3, 4);
        q.setElement(1, 1, 5);
        q.setElement(0, 1, 5);
        SquareMatrix p = new SquareMatrix(3);
        System.out.println(q.product(p));
    }
}
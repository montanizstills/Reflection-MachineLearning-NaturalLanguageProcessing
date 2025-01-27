import org.junit.jupiter.api.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class TestMatrixOperations {

    @Test
    public void TestMultiplyTwoMatrix() {
        // Example: [1,2] @ [2,3]
        INDArray A = Nd4j.create(new double[]{1, 2}, 1, 2);
        INDArray B = Nd4j.create(new double[]{2, 3}, 2, 1);

        // Expected: [1,2] @ [2,3] = [8]
        INDArray result = Nd4j.create(new double[]{8}, 1, 1);
        // System.out.println(result);

        // assert A @ B == result
        assert A.mmul(B).equals(result);
    }

    @Test
    public void TestMatrixShape() {
        INDArray A = Nd4j.create(new double[]{1, 2,}, 2, 2);
        System.out.println(A.shape()[0]);
        assert A.shape()[0] == 2;
    }

    @Test
    public void TestConcatenation() {
        // Create two row vectors
        INDArray rowVector1 = Nd4j.create(new double[]{1, 2, 3});
        System.out.println(rowVector1);
        INDArray rowVector2 = Nd4j.create(new double[]{4, 5, 6});
        System.out.println(rowVector2);

        // Stack the row vectors along the first dimension (rows)
        INDArray vstack = Nd4j.vstack(rowVector1, rowVector2);
        INDArray hStack = Nd4j.hstack(rowVector1,rowVector2);

        System.out.println("Stacked INDArray:");
        System.out.println("vStacked: "+vstack);
        System.out.println("hStacked: "+hStack);

        assert false;
    }

    @Test
    public void TestNd4jSuite(){
        INDArray originalArray = Nd4j.linspace(1,15,15).reshape('c',3,5);
        System.out.println("Original Array:");
        System.out.println(originalArray);

    }
}

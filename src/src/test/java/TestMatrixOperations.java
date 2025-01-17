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
    public void TestMatrixShape(){
        INDArray A = Nd4j.create(new double[]{1, 2,}, 2, 2);
        System.out.println(A.shape()[0]);
        assert A.shape()[0] == 2;
    }
}

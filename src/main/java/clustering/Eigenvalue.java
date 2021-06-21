package clustering;

import Jama.EigenvalueDecomposition;
import Jama.Matrix;

public class Eigenvalue {

    public void produceEigenvalue(Matrix matrix) {

        //              Print out initial matrix to System.out on
        //              cole of with 8 with 4 sig figs
        System.out.println("Initial Radom Matrix is:");
        matrix.print(8, 4);


        //                  Get the Eigen value decomposition
        EigenvalueDecomposition eigen = matrix.eig();

        double[] realPart = eigen.getRealEigenvalues();
        double[] imagPart = eigen.getImagEigenvalues();

        for (int i = 0; i < realPart.length; i++) {
            System.out.println("Eigen Value " + i + " is " +
                    "[" + realPart[i] + ", " +
                    +imagPart[i] + "]");
        }


        //                 Get the block diagonal matrix of
        //                 Eigen values
        Matrix d = eigen.getD();
        System.out.println("Diagonal matrix of Eigen values is:");
        d.print(8, 4);


        Matrix evectors = eigen.getV();

        System.out.println("Matrix of Eigen Vectors is:");
        evectors.print(8, 4);

        //           Get transpose of evectors
        Matrix trans = evectors.transpose();

        //           Form trans*evectors (which should be unit matrix)
        Matrix u = evectors.times(trans);

        System.out.println("Matrix of trans * evectors is :");
        u.print(8, 4);


    }
}
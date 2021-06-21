package clustering;

import Jama.EigenvalueDecomposition;
import Jama.Matrix;
import graph.CloudLet;

import java.util.Arrays;
import java.util.List;

public class SpectralClustering {

    public void produce(List<CloudLet> cloudLets) {

        // The size of all Graph nodes
        int size = cloudLets.size();

        // Adjacency Matrix
        double[][] adjacencyMatrix = new double[size + 1][size + 1];

        // Adjacency2 Matrix when have edge is -1 else 0
        double[][] laplacian = new double[size + 1][size + 1];


        ////////////////// Adjacency Matrix2 baraye matrix bedoone node isole
        double[][] adjacencyMatrix2 = new double[size][size];


        // Degree Matrix
        int[][] degreeMatrix = new int[size + 1][size + 1];




        System.out.println("adjencency Matrix2 is  :   ");
        ///////////////// print kardan adMatrixj 2
        for (int i = 0; i < adjacencyMatrix2.length; i++) {
            for (int j = 0; j < adjacencyMatrix2[i].length; j++) {
                System.out.print(adjacencyMatrix2[i][j] + " ");
            }
            System.out.println();
        }



        for (CloudLet c : cloudLets) {

            // satre entekhab shode
            Integer to = c.getIndex();

            // barae jame node haye motasel shode
            final int[] count = {0};

            // bad az chakhesh yalhaye node entekhabi arraye andise an ra barabare meghdare weight garar midahad
            c.getEdges().forEach(f -> {
                // set weight cloudLet index and edge to weight
                adjacencyMatrix[to][f.getDestination().getIndex()] = f.getWeight();

                // set weight cloudLet index and edge to -1
                laplacian[to][f.getDestination().getIndex()] = -1;

                count[0] += 1;
            });
            // قطر اصلی ماتریس برابر مقدار ماترین درجه است
            laplacian[to][to] = count[0];

            // پر کردن ماتریس درجه
            degreeMatrix[to][to] = count[0];
        }
        Matrix matrix = new Matrix(adjacencyMatrix);
        //matrix.eig();
        //Eigenvalue eigenvalue = new Eigenvalue();
        //eigenvalue.produceEigenvalue(matrix);
        for (int i = 0; i < laplacian.length; i++) {
            for (int j = 0; j < laplacian[i].length; j++) {
                System.out.print(laplacian[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
//---------------------------
        //smile.math.matrix.Matrix matrix1 = new smile.math.matrix.Matrix(size + 1, size + 1, adjacencyMatrix);

       // smile.clustering.SpectralClustering.fit(matrix1, 3);
 // --------------------------------------------------------


        Matrix M = new Matrix(adjacencyMatrix2);
        EigenvalueDecomposition E = new EigenvalueDecomposition(M);
        double[] d = E.getRealEigenvalues();
        Matrix D = E.getD();
        Matrix V = E.getV();

        System.out.println("-----------------------------------------\n");
        System.out.println("Value_Vector: ");
        Arrays.stream(D.getArray()).forEach(System.out::println);

        Arrays.stream(V.getArray()).forEach(System.out::println);


        double D_double [][] = D.getArray();


        System.out.println();





    }

}

import clustering.SpectralClustering;
import graph.CloudLet;
import graph.CloudLetGrah;

import smile.math.matrix.Matrix;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        CloudLetGrah cloudLetGrah = new CloudLetGrah();
        List<CloudLet> cloudLets = cloudLetGrah.produceGraph();
        // print graph in console
        System.out.println(cloudLetGrah);
        SpectralClustering spectralClustering = new SpectralClustering();
        spectralClustering.produce(cloudLets);

//        double[][] arr = { { 1, 2 }, { 3, 4 } };
//        Matrix matrix = new Matrix(2, 2, arr);
//
//        SpectralClustering fit = SpectralClustering.fit(matrix, 3);







    }
}

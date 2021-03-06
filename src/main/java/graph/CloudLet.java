package graph;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.UtilizationModel;

import java.util.Set;

@Getter
@Setter
@ToString
public class CloudLet extends Cloudlet implements Comparable<CloudLet> {
    private Integer index;
    private String name;
    private Double weight;
    private Set<Edge> edges;



    public CloudLet(int cloudletId, long cloudletLength, int pesNumber, long cloudletFileSize, long cloudletOutputSize, UtilizationModel utilizationModelCpu, UtilizationModel utilizationModelRam, UtilizationModel utilizationModelBw) {
        super(cloudletId, cloudletLength, pesNumber, cloudletFileSize, cloudletOutputSize, utilizationModelCpu, utilizationModelRam, utilizationModelBw);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        CloudLet cloudLet = (CloudLet) o;
        return index.equals(cloudLet.index) && (name.equals(cloudLet.name));
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + index.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public int compareTo(CloudLet o) {
        return this.index - o.index;
    }
}
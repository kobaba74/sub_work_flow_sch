package graph;

import lombok.Getter;
import lombok.Setter;
import org.cloudbus.cloudsim.CloudletScheduler;
import org.cloudbus.cloudsim.CloudletSchedulerTimeShared;
import org.cloudbus.cloudsim.Vm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class MyVm extends Vm {

    public MyVm(int id, int userId, double mips, int numberOfPes, int ram, long bw, long size, String vmm, CloudletScheduler cloudletScheduler) {
        super(id, userId, mips, numberOfPes, ram, bw, size, vmm, cloudletScheduler);
    }

    private Long freeSize;
    private Integer freeRam;
    private Integer freeNumberOfPes;

    private Long usedSize;
    private Integer usedRam;
    private Integer usedNumberOfPes;


    public static List<MyVm> produceVms(Integer brokerId) {
        List<MyVm> vms = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            if (i < 2) {
                addVm(vms, i, brokerId);
            } else if (i < 4) {
                addVm(vms, i, brokerId);
            } else if (i < 6) {
                addVm(vms, i, brokerId);
            } else {
                addVm(vms, i, brokerId);
            }
        }

        return vms;
    }

    private static void addVm(List<MyVm> vms, int i, int brokerId) {
        vms.add(createVm(i, brokerId, 250, 1, 1024, 1000, 1000));
    }

    private static MyVm createVm(Integer vmid, Integer brokerId, double misps, int numberOfPes, int ram, int bw, int size) {

        int[] ramValue = {1024, 2048, 4096};

        MyVm myVm = new MyVm(vmid,
                brokerId,
                misps * (vmid == 0 ? 1 : vmid),
                numberOfPes * (vmid == 0 ? 1 : vmid),
                ramValue[new Random().nextInt(ramValue.length)],
                bw * (vmid == 0 ? 1 : vmid),
                size * (vmid == 0 ? 1 : vmid),
                "VM_" + vmid,
                new CloudletSchedulerTimeShared());

        Random random = new Random();

        myVm.setUsedNumberOfPes(random.nextInt(myVm.getNumberOfPes()));
        myVm.setUsedRam(random.nextInt(myVm.getRam()));
        myVm.setUsedSize((long) random.nextInt((int) myVm.getSize()));

        myVm.setFreeNumberOfPes(myVm.getNumberOfPes() - myVm.getUsedNumberOfPes());
        myVm.setFreeRam(myVm.getRam() - myVm.getUsedRam());
        myVm.setFreeSize(myVm.getSize() - myVm.getUsedSize());

        return myVm;
    }
}

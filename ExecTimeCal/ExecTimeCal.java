import etc.*;

public class ExecTimeCal {
    public static void main(String[] args) {
        // CPU Scheduling Algorithms
        // CPU_FCFS(), CPU_SJN(), CPU_RR([Time Quanta])
        CPU cpu = new CPU_RR(13);
        // Process / Job
        // new Job(JobName, ArrivalTime, BurstTime)
        cpu.addJob(new Job("J0",1,12));
        cpu.addJob(new Job("J1",21,5));
        cpu.addJob(new Job("J2",25,21));
        cpu.addJob(new Job("J3",5,14));
        cpu.addJob(new Job("J4",21,7));
        cpu.addJob(new Job("J5",14,20));
        cpu.addJob(new Job("J6",16,1));
        cpu.addJob(new Job("J7",12,11));
        cpu.addJob(new Job("J8",1,19));
        cpu.addJob(new Job("J9",10,20));
        cpu.execute();
    }
}

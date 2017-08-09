package etc;

import java.util.ArrayList;

public class CPU_FCFS extends CPU {
    @Override
    public void execute() {
        queue = new ArrayList<>();
        time = 0;
        int execTime = 0;
        int size = jobs.size();
        int totwait = 0;
        int totturn = 0;
        
        while(jobs.size()+queue.size()>0) {
            handleQueue();
            if(execTime>0) {
                execTime--;
                time++;
                continue;
            }
            Job job = getNext();
            if(job!=null) {
                System.out.println("Executed "+job.JobName+" at t="+time+", wait: "+(time-job.ArrTime)+"ms, run: "+job.BurTime+"ms");
                totwait += time-job.ArrTime;
                totturn += time+job.BurTime-job.ArrTime;
                execTime = job.BurTime;
            } else time++;
        }
        System.out.println("Done at t="+(time+execTime));
        System.out.println("#################### Statistics ####################");
        System.out.printf(" Average Waiting Time: %.2fms\n",((double)totwait/size));
        System.out.printf(" Average Turn-around Time: %.2fms\n",((double)totturn/size));
        System.out.println("Total Swap: "+size);
    }
    @Override
    protected Job getNext() {
        if(queue.size()>0) {
            Job job = queue.remove(0);
            return job;
        }
        return null;
    }
}

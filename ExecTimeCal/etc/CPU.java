package etc;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class CPU {
    protected ArrayList<Job> jobs;
    protected int time;
    protected ArrayList<Job> queue;
    
    public CPU() {
        jobs = new ArrayList<>();
    }
    public void addJob(Job job) {
        jobs.add(job);
    }
    protected void handleQueue() {
        Iterator<Job> ptr = jobs.iterator();
        while(ptr.hasNext()) {
            Job job = ptr.next();
            if(job.ArrTime==time) {
                ptr.remove();
                queue.add(job);
            }
        }
    }
    protected abstract Job getNext();
    public abstract void execute();
}

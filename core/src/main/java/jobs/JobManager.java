package jobs;

import com.badlogic.gdx.utils.Array;
import events.JobAvailableEvent;

public class JobManager {
    private static JobManager instance;
    private final Array<Job> jobs = new Array<>();

    private JobManager() {}

    public static JobManager getInstance() {
        if (instance == null) instance = new JobManager();
        return instance;
    }

    public void addJob(Job job) {
        jobs.add(job);
        Events.post(new JobAvailableEvent(job)); // Reference from events package
    }

    public Job getNextJob() {
        return jobs.size > 0 ? jobs.removeIndex(0) : null;
    }
}

package events;

import jobs.Job;

public class JobAvailableEvent {
    public final Job job;

    public JobAvailableEvent(Job job) {
        this.job = job;
    }
}
